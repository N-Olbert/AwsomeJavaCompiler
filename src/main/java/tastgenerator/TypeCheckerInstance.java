package tastgenerator;

import astgenerator.expressions.*;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.*;
import common.ObjectType;
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
            HashMap<String, Method> methods = new HashMap<>();
            for (MethodDeclaration methodDecl: currentClass.getMethods()) {
                List<ObjectType> params = new ArrayList<>();
                for (MethodParameter parameter: methodDecl.getParams()) {
                    params.add(parameter.getType());
                }
                methods.put(methodDecl.getName(), new Method(methodDecl.getReturnType(), params));
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
        return new TypedReturn(toCheck.getExp().toTyped(this));
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
            case INCREMENTBEFORE:
            case INCREMENTAFTER:
            case DECREMENTBEFORE:
            case DECREMENTAFTER:
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
        return null;
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
        return null;
    }

    @Override
    public TypedNewStatement typeCheck(NewStatement toCheck) {
        return null;
    }
}
