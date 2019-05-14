package tastgenerator;

import astgenerator.expressions.*;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.*;
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

public class TypeCheckerInstance implements TypeChecker
{

    private HashMap<String, ClassObject> classes;

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
        return null;
    }

    @Override
    public TypedReturn typeCheck(Return toCheck)
    {
        TypedExpression expression = toCheck.getExp().toTyped(this);
        return new TypedReturn(expression, expression.getObjectType());
    }

    @Override
    public TypedAssignExpression typeCheck(AssignExpression toCheck) {
        return null;
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
        return null;
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
        return null;
    }

    @Override
    public TypedLocalOrFieldVar typeCheck(LocalOrFieldVar toCheck) {
        return null;
    }

    @Override
    public TypedMethodCallExpression typeCheck(MethodCallExpression toCheck) {
        return null;
    }

    @Override
    public TypedNewExpression typeCheck(NewExpression toCheck) {
        return null;
    }

    @Override
    public TypedSuper typeCheck(Super toCheck) {
        return null;
    }

    @Override
    public TypedThis typeCheck(This toCheck) {
        return null;
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
            case MINUS:
                if (expression.getObjectType() == ObjectType.IntType || expression.getObjectType() == ObjectType.CharType) {
                    return new TypedUnary(expression, toCheck.getOperator(), ObjectType.CharType);
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
        return null;
    }

    @Override
    public TypedMethodDeclaration typeCheck(MethodDeclaration toCheck) {
        return null;
    }

    @Override
    public TypedMethodParameter typeCheck(MethodParameter toCheck) {
        return null;
    }

    @Override
    public TypedProgram typeCheck(UntypedProgram toCheck) {
        return null;
    }

    @Override
    public TypedAssignStatement typeCheck(AssignStatement toCheck) {
        return null;
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
        return null;
    }

    @Override
    public TypedMethodCallStatement typeCheck(MethodCallStatement toCheck) {
        TypedExpression typedExpression = toCheck.getObject().toTyped(this);
        if (!classes.containsKey(typedExpression.getObjectType().getName())) {
            throw new CannotResolveSymbolException("Class " + typedExpression.getObjectType().getName() + " does not exist");
        }
        List<TypedExpression> typedParams = new ArrayList<>();
        for (Expression param: toCheck.getParameters()) {
            typedParams.add(param.toTyped(this));
        }
        ClassObject classObject = classes.get(typedExpression.getObjectType().getName());
        if (!classObject.getMethods().containsKey(toCheck.getName())) {
            throw new CannotResolveSymbolException("Class " + typedExpression.getObjectType().getName() + " does not have the method " + toCheck.getName());
        }
        List<Method> methods = classObject.getMethods().get(toCheck.getName());
        Method correspondingMethod = null;
        for (Method method: methods) {
            if (method.getParams().size() == toCheck.getParameters().size()) {
                correspondingMethod = method;
                for (int i = 0; i < toCheck.getParameters().size(); i++) {
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
                    toCheck.getName() + " with the given parameters");
        }
        return new TypedMethodCallStatement(typedExpression, toCheck.getName(), typedParams, correspondingMethod.returnType);
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
}
