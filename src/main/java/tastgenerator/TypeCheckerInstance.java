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

    private List<TypedMethodParameter> methodParameters = new ArrayList<>();

    public TypeCheckerInstance(UntypedProgram program) {
        classes = new HashMap<>();
        for (Class currentClass: program.getClasses()) {
            HashMap<String, ObjectType> fields = new HashMap<>();
            for (FieldDeclaration fieldDecl: currentClass.getFields()) {
                if (fields.get(fieldDecl.getName()) != null) {
                    throw new AlreadyDefinedException("The field variable " + fieldDecl.getName() + " has already been defined");
                }
                fields.put(fieldDecl.getName(), fieldDecl.getVariableType());
            }
            HashMap<String, List<Method>> methods = new HashMap<>();
            for (MethodDeclaration methodDecl: currentClass.getMethods()) {
                List<ObjectType> params = new ArrayList<>();
                for (MethodParameter parameter: methodDecl.getParams()) {
                    params.add(parameter.getType());
                }
                Method newMethod = new Method(methodDecl.getReturnType(), params, methodDecl.getAccessModifier());
                if (methods.containsKey(methodDecl.getName())) {
                    List<Method> methodList = methods.get(methodDecl.getName());
                    Method correspondingMethod = getCorrespondingMethod(methodList, params);
                    if (correspondingMethod != null) {
                        throw new AlreadyDefinedException("The method " + methodDecl.getName() +
                                " has already been defined with these parameter types");
                    }
                    methodList.add(newMethod);
                    methods.put(methodDecl.getName(), methodList);
                } else {
                    List<Method> methodList = new ArrayList<Method>();
                    methodList.add(newMethod);
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
        if(toCheck.getExp() == null) {
            return new TypedReturn(ObjectType.VoidType);
        } else {
            TypedExpression expression = toCheck.getExp().toTyped(this);
            return new TypedReturn(expression, expression.getObjectType());
        }
    }

    @Override
    public TypedAssignExpression typeCheck(AssignExpression toCheck) {
        Tuple<TypedExpression, TypedExpression> result = typeAssign(toCheck.getExpression1(), toCheck.getExpression2());
        return new TypedAssignExpression(result.getFirst(), result.getSecond());
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
                if ((expression1.getObjectType().getName().equals(ObjectType.IntType.getName()) ||
                        expression1.getObjectType().getName().equals(ObjectType.CharType.getName())) &&
                    (expression2.getObjectType().getName().equals(ObjectType.IntType.getName()) ||
                            expression2.getObjectType().getName().equals(ObjectType.CharType.getName()))) {
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
        if (!classes.containsKey(expression.getObjectType().getName())) {
            throw new CannotResolveSymbolException("Class " + expression.getObjectType().getName() + " does not exist");
        }
        ClassObject classObject = classes.get(expression.getObjectType().getName());
        if (!classObject.getFields().containsKey(toCheck.getName())) {
            throw new CannotResolveSymbolException("Class " + expression.getObjectType().getName() +
                    " has no field with the name " + toCheck.getName());
        }
        return new TypedInstVar(expression, toCheck.getName(), classObject.getFields().get(toCheck.getName()));
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
    public TypedLocalOrFieldVar typeCheck(LocalOrFieldVar toCheck) {
        ObjectType varType = null;
        for (Tuple<String, ObjectType> localVar : currentLocalVars) {
            if (toCheck.getName().equals(localVar.getFirst())) {
                varType = localVar.getSecond();
                break;
            }
        }
        if (varType == null) {
            for (TypedMethodParameter typedParam: methodParameters) {
                if (toCheck.getName().equals(typedParam.getName())) {
                    varType = typedParam.getObjectType();
                    break;
                }
            }
        }
        if (varType == null) {
            varType = classes.get(currentClass.getName()).getFields().get(toCheck.getName());
        }
        if (varType == null) {
            throw new CannotResolveSymbolException("The variable " + toCheck.getName() + " does not exist");
        }
        return new TypedLocalOrFieldVar(varType, toCheck.getName());
    }

    @Override
    public TypedMethodCallExpression typeCheck(MethodCallExpression toCheck) {
        TypedExpression typedExpression = toCheck.getObject().toTyped(this);
        Tuple<List<TypedExpression>, ObjectType> result = methodCallTypeParamsAndGetReturnType(typedExpression,
                toCheck.getName(),toCheck.getParameters());
        return new TypedMethodCallExpression(typedExpression, toCheck.getName(), result.getFirst(), result.getSecond());
    }

    @Override
    public TypedNewExpression typeCheck(NewExpression toCheck) {
        List<TypedExpression> typedParams = typeNew(toCheck.getNewType().getName(), toCheck.getParameters());
        return new TypedNewExpression(toCheck.getNewType(), typedParams);
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
        TypedExpression typedExpression = null;
        if (toCheck.getExpression() != null) {
            typedExpression = toCheck.getExpression().toTyped(this);
            if (!toCheck.getVariableType().getName().equals(typedExpression.getObjectType().getName())) {
                throw new TypeMismatchException("Field of type " + toCheck.getVariableType() + " cannot be initialized with type " +
                        typedExpression.getObjectType());
            }
        }
        return new TypedFieldDeclaration(toCheck.getAccessModifier(),
                                         toCheck.getModifier(),
                                         toCheck.getVariableType(),
                                         toCheck.getName(),
                                         typedExpression);
    }

    @Override
    public TypedMethodDeclaration typeCheck(MethodDeclaration toCheck) {
        List<TypedMethodParameter> typedParams = new ArrayList<>();
        List<ObjectType> types = new ArrayList<>();
        for (MethodParameter parameter: toCheck.getParams()) {
            typedParams.add((TypedMethodParameter) parameter.toTyped(this));
            types.add(parameter.toTyped(this).getObjectType());
        }
        //Update the list of methodparameters so a local or field var has access to them
        methodParameters = typedParams;
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
        Tuple<TypedExpression, TypedExpression> result = typeAssign(toCheck.getExpression1(), toCheck.getExpression2());
        return new TypedAssignStatement(result.getFirst(), result.getSecond());
    }

    @Override
    public TypedBlock typeCheck(Block toCheck) {
        localVarCount.push(0);
        List<TypedStatement> statements = new ArrayList<>();
        ObjectType type = ObjectType.VoidType;
        for(Statement statement: toCheck.getBlockedStatements()) {
            TypedStatement typedStatement = statement.toTyped(this);
            if (type.getName().equals(ObjectType.VoidType.getName())) {
                type = typedStatement.getObjectType();
            } else if (!typedStatement.getObjectType().getName().equals(ObjectType.VoidType.getName()) &&
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
        TypedExpression typedCondition = toCheck.getCondition().toTyped(this);
        if (!typedCondition.getObjectType().getName().equals(ObjectType.BoolType.getName())) {
            throw new TypeMismatchException("Condition of while must be boolean");
        }
        TypedBlock typedThen = (TypedBlock) toCheck.getThen().toTyped(this);
        TypedBlock typedOtherwise = (TypedBlock) toCheck.getOtherwise().toTyped(this);
        ObjectType type;
        if (typedOtherwise.getObjectType().getName().equals(ObjectType.VoidType.getName()) ||
                typedThen.getObjectType().getName().equals(typedOtherwise.getObjectType().getName())) {
            type = typedThen.getObjectType();
        } else {
            if (typedThen.getObjectType().getName().equals(ObjectType.VoidType.getName())) {
                type = typedOtherwise.getObjectType();
            } else {
                if ((typedThen.getObjectType().getName().equals(ObjectType.CharType.getName()) &&
                    typedOtherwise.getObjectType().getName().equals(ObjectType.IntType.getName())) ||
                    (typedThen.getObjectType().getName().equals(ObjectType.IntType.getName()) &&
                    typedOtherwise.getObjectType().getName().equals(ObjectType.CharType.getName()))) {
                    type = ObjectType.IntType;
                } else {
                    type = ObjectType.JObjectType;
                }
            }
        }
        return new TypedIfElse(typedCondition, typedThen, typedOtherwise, type);
    }

    @Override
    public TypedLocalVarDeclaration typeCheck(LocalVarDeclaration toCheck) {
        for (Tuple<String, ObjectType> currentLocalVar: currentLocalVars) {
            if (currentLocalVar.getFirst().equals(toCheck.getName())) {
                throw new AlreadyDefinedException("Variable " + toCheck.getName() + " is already defined in the local scope");
            }
        }
        for (TypedMethodParameter typedParam: methodParameters) {
            if (toCheck.getName().equals(typedParam.getName())) {
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
        return new TypedMethodCallStatement(typedExpression, toCheck.getName(), result.getFirst(), ObjectType.VoidType);
    }

    @Override
    public TypedNewStatement typeCheck(NewStatement toCheck) {
        List<TypedExpression> typedParams = typeNew(toCheck.getNewType().getName(), toCheck.getParameters());
        return new TypedNewStatement(toCheck.getNewType(), typedParams);
    }

    /**
     * Compares two types to see if type2 can be applied to type1 (for example for Assign or Return)
     * @param type1 The first type
     * @param type2 The second type
     * @return true, if type2 can be applied to type1, else otherwise
     */
    private boolean compareTypes(ObjectType type1, ObjectType type2) {
        return (type1.getName().equals(type2.getName()) ||
                type1.getName().equals("Object")) ||
                (type1.getName().equals(ObjectType.IntType.getName()) &&
                        type2.getName().equals(ObjectType.CharType.getName()));
    }

    /**
     * @param typedExpression The expression of the methodCall
     * @param methodName The name of the method that is called
     * @param params The list of parameters, that are used to call the method
     * @return A tuple that contains the typed Parameters and the returnType of the method
     */
    private Tuple<List<TypedExpression>, ObjectType> methodCallTypeParamsAndGetReturnType(TypedExpression typedExpression,
                                                                                          String methodName,
                                                                                          List<Expression> params) {
        if (!classes.containsKey(typedExpression.getObjectType().getName())) {
            throw new CannotResolveSymbolException("Class " + typedExpression.getObjectType().getName() + " does not exist");
        }
        List<TypedExpression> typedParams = new ArrayList<>();
        List<ObjectType> types = new ArrayList<>();
        for (Expression param: params) {
            typedParams.add(param.toTyped(this));
            types.add(param.toTyped(this).getObjectType());
        }
        ClassObject classObject = classes.get(typedExpression.getObjectType().getName());
        if (!classObject.getMethods().containsKey(methodName)) {
            throw new CannotResolveSymbolException("Class " + typedExpression.getObjectType().getName() + " does not have the method " + methodName);
        }
        List<Method> methods = classObject.getMethods().get(methodName);
        Method correspondingMethod = getCorrespondingMethod(methods, types);
        if (correspondingMethod == null) {
            throw new CannotResolveSymbolException("Class " + typedExpression.getObjectType().getName() + " does not have method " +
                    methodName + " with the given parameters");
        }
        return new Tuple<>(typedParams, correspondingMethod.getReturnType());
    }

    /**
     * @param methods List of methods with the same name
     * @param types Types of the parameters
     * @return The method whose parameter types match the List of types, or null if no matching method is found
     */
    private Method getCorrespondingMethod(List<Method> methods, List<ObjectType> types) {
        Method correspondingMethod = null;
        for (Method method: methods) {
            if (method.getParams().size() == types.size()) {
                correspondingMethod = method;
                for (int i = 0; i < types.size(); i++) {
                    if (!method.getParams().get(i).getName().equals(types.get(i).getName())) {
                        correspondingMethod = null;
                        break;
                    }
                }
                if (correspondingMethod != null) {
                    break;
                }
            }
        }
        return correspondingMethod;
    }

    /**
     * @param expression1 The first expression of the assign
     * @param expression2 The second expression of the assign
     * @return A Tuple that contains the typed version of both expressions
     */
    private Tuple<TypedExpression, TypedExpression> typeAssign(Expression expression1, Expression expression2) {
        TypedExpression typedExpression1 = expression1.toTyped(this);
        TypedExpression typedExpression2 = expression2.toTyped(this);
        if (!(typedExpression1 instanceof TypedLocalOrFieldVar || typedExpression1 instanceof TypedInstVar)) {
            throw new InvalidASTException("Left side of the assign is not assignable");
        }
        if (!compareTypes(typedExpression1.getObjectType(), typedExpression2.getObjectType())) {
            throw new TypeMismatchException("Type " + typedExpression2.getObjectType().getName() + " cannot be assigned to " +
                    typedExpression1.getObjectType().getName());
        }
        return new Tuple<>(typedExpression1, typedExpression2);
    }

    /**
     * @param name The name of the class that is instantiated
     * @param params The parameters for the constructor
     * @return A list of typedParameters
     */
    private List<TypedExpression> typeNew(String name, List<Expression> params) {
        if (!classes.containsKey(name)) {
            throw new TypeMismatchException("This class does not exist");
        }
        List<TypedExpression> typedParameters = new ArrayList<>();
        for (Expression parameter: params) {
            typedParameters.add(parameter.toTyped(this));
        }
        return typedParameters;
    }
}
