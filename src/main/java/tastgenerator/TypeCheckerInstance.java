package tastgenerator;

import astgenerator.expressions.*;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.*;
import com.sun.jdi.VoidType;
import common.ObjectType;
import tastgenerator.exceptions.AlreadyDefinedException;
import tastgenerator.exceptions.CannotResolveSymbolException;
import tastgenerator.exceptions.InvalidASTException;
import tastgenerator.exceptions.TypeMismatchException;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.*;
import tastgenerator.statements.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class TypeCheckerInstance implements TypeChecker
{

    private HashMap<String, ClassObject> classes;

    private ObjectType currentClass;

    private List<Tuple<String, ObjectType>> currentLocalVars = new ArrayList<>();

    private Stack<Integer> localVarCount= new Stack<>();

    public TypeCheckerInstance(UntypedProgram program) {
        classes = new HashMap<>();
        for (Class currentClass: program.getClasses()) {
            HashMap<String, ObjectType> fields = new HashMap<>();
            for (FieldDeclaration fieldDecl: currentClass.getFields()) {
                fields.put(fieldDecl.getName(), fieldDecl.getVariableType());
            }
            HashMap<String, List<Method>> methods = new HashMap<>();
            for (MethodDeclaration methodDecl: currentClass.getMethods()) {
                List<ObjectType> params = new ArrayList<>();
                for (MethodParameter parameter: methodDecl.getParams()) {
                    params.add(parameter.getType());
                }
                Method newMethod = new Method(methodDecl.getReturnType(), params);
                if (methods.containsKey(methodDecl.getName())) {
                    List<Method> methodList = methods.get(methodDecl.getName());
                    methodList.add(newMethod);
                    methods.put(methodDecl.getName(), methodList);
                } else {
                    List<Method> methodList = new ArrayList<Method>();
                    methodList.add(new Method(methodDecl.getReturnType(), params));
                    methods.put(methodDecl.getName(), methodList);
                }
            }
            classes.put(currentClass.getClassType().getName(), new ClassObject(fields, methods));
        }
    }

    @Override
    public TypedWhile typeCheck(While toCheck)
    {
        TypedExpression typedCondition = toCheck.getExp().toTyped(this);
        if (!typedCondition.getObjectType().getName().equals(ObjectType.BoolType.getName())) {
            throw new TypeMismatchException("Condition of while must be boolean");
        }
        TypedBlock typedBlock = (TypedBlock) toCheck.getStmt().toTyped(this);
        return new TypedWhile(typedCondition, typedBlock, typedBlock.getObjectType());
    }

    @Override
    public TypedReturn typeCheck(Return toCheck)
    {
        TypedExpression expression = toCheck.getExp().toTyped(this);
        return new TypedReturn(expression, expression.getObjectType());
    }

    @Override
    public TypedAssignExpression typeCheck(AssignExpression toCheck) {
        TypedExpression expression1 = toCheck.getExpression1().toTyped(this);
        TypedExpression expression2 = toCheck.getExpression2().toTyped(this);
        if (!(expression1 instanceof TypedLocalOrFieldVar || expression1 instanceof TypedInstVar)) {
            throw new InvalidASTException("Left side of the assign is not assignable");
        }
        if (!compareTypes(expression1.getObjectType(), expression2.getObjectType())) {
            throw new TypeMismatchException("Types of the left and right side of the assign do not match");
        }
        return new TypedAssignExpression(expression1, expression2, expression1.getObjectType());
    }

    @Override
    public TypedBinary typeCheck(Binary toCheck)
    {
        TypedExpression expression1 = toCheck.getExpression().toTyped(this);
        TypedExpression expression2 = toCheck.getExpression2().toTyped(this);
        switch (toCheck.getOperator()){
            case PLUS:
            case MINUS:
            case MULTIPLICATION:
            case DIVISION:
            case MODULO:
                if ((expression1.getObjectType() == ObjectType.IntType || expression1.getObjectType() == ObjectType.CharType) &&
                    (expression2.getObjectType() == ObjectType.IntType || expression2.getObjectType() == ObjectType.CharType)) {
                    return new TypedBinary(expression1, expression2, toCheck.getOperator(), ObjectType.IntType);
                } else {
                    throw new TypeMismatchException("Type Mismatch: Cannot apply " + toCheck.getOperator().name() + " to '" +
                            expression1.getObjectType().getName() + "' and '" + expression2.getObjectType().getName() + "'");
                }
            case AND:
            case OR:
            case XOR:
                if (expression1.getObjectType() == ObjectType.BoolType && expression2.getObjectType() == ObjectType.BoolType) {
                    return new TypedBinary(expression1, expression2, toCheck.getOperator(), ObjectType.BoolType);
                } else {
                    throw new TypeMismatchException("Type Mismatch: Cannot apply " + toCheck.getOperator().name() + " to '" +
                            expression1.getObjectType().getName() + "' and '" + expression2.getObjectType().getName() + "'");
                }
            case GREATERTHAN:
            case GREATEROREQUAL:
            case LESSTHAN:
            case LESSOREQUAL:
                if ((expression1.getObjectType() == ObjectType.IntType || expression1.getObjectType() == ObjectType.CharType) &&
                    (expression2.getObjectType() == ObjectType.IntType || expression2.getObjectType() == ObjectType.CharType)) {
                    return new TypedBinary(expression1, expression2, toCheck.getOperator(), ObjectType.BoolType);
                } else {
                    throw new TypeMismatchException("Type Mismatch: Cannot apply " + toCheck.getOperator().name() + " to '" +
                            expression1.getObjectType().getName() + "' and '" + expression2.getObjectType().getName() + "'");
                }
            case EQUALS:
            case NOTEQUALS:
                if (((expression1.getObjectType() == ObjectType.IntType || expression1.getObjectType() == ObjectType.CharType) &&
                     (expression2.getObjectType() == ObjectType.IntType || expression2.getObjectType() == ObjectType.CharType)) ||
                     (expression1.getObjectType() == ObjectType.BoolType && expression2.getObjectType() == ObjectType.BoolType)) {
                    return new TypedBinary(expression1, expression2, toCheck.getOperator(), ObjectType.BoolType);
                } else {
                    throw new TypeMismatchException("Type Mismatch: Cannot apply " + toCheck.getOperator().name() + " to '" +
                            expression1.getObjectType().getName() + "' and '" + expression2.getObjectType().getName() + "'");
                }
            default:
                throw new InvalidASTException("invalid operator");
        }
    }

    @Override
    public TypedInstVar typeCheck(InstVar toCheck) {
        TypedExpression expression = toCheck.getExpression().toTyped(this);
        return new TypedInstVar(expression, toCheck.getName());
    }

    @Override
    public TypedBoolean typeCheck(JBoolean toCheck) {
        return new TypedBoolean(Boolean.toString(toCheck.getJBool()));
    }

    @Override
    public TypedChar typeCheck(JCharacter toCheck) {
        return new TypedChar(String.valueOf(toCheck.getJChar()));
    }

    @Override
    public TypedInt typeCheck(JInteger toCheck) {
        return new TypedInt(Integer.toString(toCheck.getJint()));
    }

    @Override
    public TypedNull typeCheck(JNull toCheck) {
        return new TypedNull();
    }

    @Override
    public TypedString typeCheck(JString toCheck) {
        return new TypedString(toCheck.getJString());
    }

    @Override
    public TypedLocalOrFieldVar typeCheck(LocalOrFieldVar toCheck) {
        return null;
    }

    @Override
    public TypedMethodCallExpression typeCheck(MethodCallExpression toCheck) {
        TypedExpression typedExpression = toCheck.getObject().toTyped(this);
        Tuple<List<TypedExpression>, ObjectType> result = methodCallTypeParamsAndGetReturnType(typedExpression,
                toCheck.getName(),toCheck.getParameters());
        return new TypedMethodCallExpression(typedExpression, toCheck.getName(), result.getFirst(), ObjectType.VoidType);
    }

    @Override
    public TypedNewExpression typeCheck(NewExpression toCheck) {
        if (!classes.containsKey(toCheck.getNewType().getName())) {
            throw new TypeMismatchException("This class does not exist");
        }
        List<TypedExpression> typedParameters = new ArrayList<>();
        for (Expression parameter: toCheck.getParameters()) {
            typedParameters.add(parameter.toTyped(this));
        }
        return new TypedNewExpression(toCheck.getNewType(), typedParameters, toCheck.getNewType());
    }

    @Override
    public TypedSuper typeCheck(Super toCheck) {
        return new TypedSuper(ObjectType.JObjectType);
    }

    @Override
    public TypedThis typeCheck(This toCheck) {
        return new TypedThis(currentClass);
    }

    @Override
    public TypedUnary typeCheck(Unary toCheck) {
        TypedExpression expression = toCheck.getExpression().toTyped(this);
        switch(toCheck.getOperator()) {
            case NEGATION:
                if (expression.getObjectType() == ObjectType.BoolType) {
                    return new TypedUnary(expression, toCheck.getOperator(), ObjectType.BoolType);
                } else {
                    throw new TypeMismatchException("Type Mismatch: Cannot apply " + toCheck.getOperator().name() + " to '" +
                            expression.getObjectType().getName() + "'");
                }
            case PLUS:
                if (expression.getObjectType() == ObjectType.CharType || expression.getObjectType() == ObjectType.IntType) {
                    return new TypedUnary(expression, toCheck.getOperator(), expression.getObjectType());
                } else {
                    throw new TypeMismatchException("Type Mismatch: Cannot apply " + toCheck.getOperator().name() + " to '" +
                            expression.getObjectType().getName() + "'");
                }
            case MINUS:
                if (expression.getObjectType() == ObjectType.IntType || expression.getObjectType() == ObjectType.CharType) {
                    return new TypedUnary(expression, toCheck.getOperator(), ObjectType.IntType);
                } else {
                    throw new TypeMismatchException("Type Mismatch: Cannot apply " + toCheck.getOperator().name() + " to '" +
                            expression.getObjectType().getName() + "'");
                }
            default:
                throw new InvalidASTException("invalid operator");
        }
    }

    @Override
    public TypedClass typeCheck(Class toCheck) {
        List<TypedFieldDeclaration> typedFields = new ArrayList<>();
        for(FieldDeclaration field: toCheck.getFields()){
            typedFields.add((TypedFieldDeclaration) field.toTyped(this));
        }

        List<TypedMethodDeclaration> typedMethods = new ArrayList<>();
        for(MethodDeclaration method: toCheck.getMethods()){
            typedMethods.add((TypedMethodDeclaration) method.toTyped(this));
        }
        return new TypedClass(toCheck.getClassType(), typedFields, typedMethods);
    }

    @Override
    public TypedFieldDeclaration typeCheck(FieldDeclaration toCheck) {
        return new TypedFieldDeclaration(toCheck.getAccessModifier(),
                                         toCheck.getModifier(),
                                         toCheck.getVariableType(),
                                         toCheck.getName());
    }

    @Override
    public TypedMethodDeclaration typeCheck(MethodDeclaration toCheck) {
        List<TypedMethodParameter> typedParams = new ArrayList<>();
        for (MethodParameter parameter: toCheck.getParams()) {
            typedParams.add((TypedMethodParameter) parameter.toTyped(this));
        }
        TypedBlock typedBlock = (TypedBlock) toCheck.getStmt().toTyped(this);
        if (!compareTypes(toCheck.getReturnType(), typedBlock.getObjectType())) {
            throw new TypeMismatchException("Returned type does not equal the specified return type of the method");
        }
        return new TypedMethodDeclaration(toCheck.getAccessModifier(), toCheck.getModifier(),
                toCheck.getReturnType(), toCheck.getName(), typedParams, typedBlock);
    }

    @Override
    public TypedMethodParameter typeCheck(MethodParameter toCheck) {
        return new TypedMethodParameter(toCheck.getType(), toCheck.getName());
    }

    @Override
    public TypedProgram typeCheck(UntypedProgram toCheck) {
        List<TypedClass> typedClasses = new ArrayList<>();
        for (Class classObj: toCheck.getClasses()) {
            currentClass = classObj.getClassType();
            typedClasses.add((TypedClass) classObj.toTyped(this));
        }
        return new TypedProgram(typedClasses);
    }

    @Override
    public TypedAssignStatement typeCheck(AssignStatement toCheck) {
        TypedExpression expression1 = toCheck.getExpression1().toTyped(this);
        TypedExpression expression2 = toCheck.getExpression2().toTyped(this);
        if (!(expression1 instanceof TypedLocalOrFieldVar || expression1 instanceof TypedInstVar)) {
            throw new InvalidASTException("Left side of the assign is not assignable");
        }
        if (!compareTypes(expression1.getObjectType(), expression2.getObjectType())) {
            throw new TypeMismatchException("Types of the left and right side of the assign do not match");
        }
        return new TypedAssignStatement(expression1, expression2, ObjectType.VoidType);
    }

    @Override
    public TypedBlock typeCheck(Block toCheck) {
        localVarCount.push(0);
        List<TypedStatement> statements = new ArrayList<>();
        ObjectType type = ObjectType.VoidType;
        for(Statement statement: toCheck.getBlockedStatements()) {
            TypedStatement typedStatement = statement.toTyped(this);
            if (!typedStatement.getObjectType().getName().equals(ObjectType.VoidType.getName()) &&
                    !typedStatement.getObjectType().getName().equals(type.getName())) {
                if (type.getName().equals(ObjectType.CharType.getName()) &&
                        typedStatement.getObjectType().getName().equals(ObjectType.IntType.getName())) {
                    type = ObjectType.IntType;
                } else {
                    type = ObjectType.JObjectType;
                }
            }
            statements.add(typedStatement);
        }
        int currentLocalVarCount = localVarCount.pop();
        for (int i = 0; i < currentLocalVarCount; i++) {
            currentLocalVars.remove(currentLocalVars.size() - 1);
        }
        return new TypedBlock(statements, type);
    }

    @Override
    public TypedIfElse typeCheck(IfElse toCheck) {
        return null;
    }

    @Override
    public TypedLocalVarDeclaration typeCheck(LocalVarDeclaration toCheck) {
        for (Tuple<String, ObjectType> currentLocalVar: currentLocalVars) {
            if (currentLocalVar.getFirst().equals(toCheck.getName())) {
                throw new AlreadyDefinedException("Variable " + toCheck.getName() + " is already defined in the local scope");
            }
        }
        currentLocalVars.add(new Tuple<String, ObjectType>(toCheck.getName(), toCheck.getVariableType()));
        localVarCount.push(localVarCount.pop() + 1);
        return new TypedLocalVarDeclaration(toCheck.getVariableType(), toCheck.getName());
    }

    @Override
    public TypedMethodCallStatement typeCheck(MethodCallStatement toCheck) {
        TypedExpression typedExpression = toCheck.getObject().toTyped(this);
        Tuple<List<TypedExpression>, ObjectType> result = methodCallTypeParamsAndGetReturnType(typedExpression,
                toCheck.getName(),toCheck.getParameters());
        return new TypedMethodCallStatement(typedExpression, toCheck.getName(), result.getFirst(), result.getSecond());
    }

    @Override
    public TypedNewStatement typeCheck(NewStatement toCheck) {
        if (!classes.containsKey(toCheck.getNewType().getName())) {
            throw new TypeMismatchException("This class does not exist");
        }
        List<TypedExpression> typedParameters = new ArrayList<>();
        for (Expression parameter: toCheck.getParameters()) {
            typedParameters.add(parameter.toTyped(this));
        }
        return new TypedNewStatement(toCheck.getNewType(), typedParameters, toCheck.getNewType());
    }

    private boolean compareTypes(ObjectType type1, ObjectType type2) {
        return (type1.getName().equals(type2.getName()) ||
                type1.getName().equals("Object")) ||
                (type1.getName().equals(ObjectType.IntType.getName()) &&
                        type2.getName().equals(ObjectType.CharType.getName()));
    }

    private Tuple<List<TypedExpression>, ObjectType> methodCallTypeParamsAndGetReturnType(TypedExpression typedExpression,
                                                                                          String methodName,
                                                                                          List<Expression> params) {
        if (!classes.containsKey(typedExpression.getObjectType().getName())) {
            throw new CannotResolveSymbolException("Class " + typedExpression.getObjectType().getName() + " does not exist");
        }
        List<TypedExpression> typedParams = new ArrayList<>();
        for (Expression param: params) {
            typedParams.add(param.toTyped(this));
        }
        ClassObject classObject = classes.get(typedExpression.getObjectType().getName());
        if (!classObject.getMethods().containsKey(methodName)) {
            throw new CannotResolveSymbolException("Class " + typedExpression.getObjectType().getName() + " does not have the method " + methodName);
        }
        List<Method> methods = classObject.getMethods().get(methodName);
        Method correspondingMethod = null;
        for (Method method: methods) {
            if (method.getParams().size() == params.size()) {
                correspondingMethod = method;
                for (int i = 0; i < params.size(); i++) {
                    if (!method.getParams().get(i).getName().equals(typedParams.get(i).getObjectType().getName())) {
                        correspondingMethod = null;
                        break;
                    }
                }
                if (correspondingMethod != null) {
                    break;
                }
            }
        }
        if (correspondingMethod == null) {
            throw new CannotResolveSymbolException("Class " + typedExpression.getObjectType().getName() + " does not have method " +
                    methodName + " with the given parameters");
        }
        return new Tuple<>(typedParams, correspondingMethod.getReturnType());
    }
}
