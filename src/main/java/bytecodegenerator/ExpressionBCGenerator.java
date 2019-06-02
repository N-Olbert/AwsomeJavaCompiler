package bytecodegenerator;

import bytecodegenerator.exceptions.InvalidOperationException;
import bytecodegenerator.exceptions.NotImplementedYetException;
import common.ObjectType;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedAssignExpression;
import tastgenerator.expressions.TypedBinary;
import tastgenerator.expressions.TypedBoolean;
import tastgenerator.expressions.TypedChar;
import tastgenerator.expressions.TypedExpression;
import tastgenerator.expressions.TypedInstVar;
import tastgenerator.expressions.TypedInt;
import tastgenerator.expressions.TypedLocalOrFieldVar;
import tastgenerator.expressions.TypedMethodCallExpression;
import tastgenerator.expressions.TypedNewExpression;
import tastgenerator.expressions.TypedNull;
import tastgenerator.expressions.TypedString;
import tastgenerator.expressions.TypedSuper;
import tastgenerator.expressions.TypedThis;
import tastgenerator.expressions.TypedUnary;

import static bytecodegenerator.GeneratorUtils.*;
import static org.objectweb.asm.Opcodes.*;

public class ExpressionBCGenerator {

    public static void generate(TypedNull expression, MethodVisitor visitor, Context context) {
        visitor.visitInsn(ACONST_NULL);
    }

    public static void generate(TypedThis expression, MethodVisitor visitor, Context context) {
        visitor.visitVarInsn(ALOAD, 0);
    }

    public static void generate(TypedString expression, MethodVisitor visitor, Context context) {
        visitor.visitLdcInsn(expression.getJString());
    }

    public static void generate(TypedBoolean typedBoolean, MethodVisitor visitor, Context context) {
        if(typedBoolean.getJBool()) {
            visitor.visitInsn(ICONST_1);
        }
        else {
            visitor.visitInsn(ICONST_0);
        }
    }

    public static void generate(TypedInt expression, MethodVisitor visitor, Context context) {
        switch(expression.getJint()) {
            case -1:
                visitor.visitInsn(ICONST_M1);
                break;
            case 0:
                visitor.visitInsn(ICONST_0);
                break;
            case 1:
                visitor.visitInsn(ICONST_1);
                break;
            case 2:
                visitor.visitInsn(ICONST_2);
                break;
            case 3:
                visitor.visitInsn(ICONST_3);
                break;
            case 4:
                visitor.visitInsn(ICONST_4);
                break;
            case 5:
                visitor.visitInsn(ICONST_5);
                break;
            default:
                visitor.visitIntInsn(BIPUSH, expression.getJint());
                break;
        }
    }

    public static void generate(TypedChar expression, MethodVisitor visitor, Context context) {
        switch(expression.getJChar()) {
            case 0:
                visitor.visitInsn(ICONST_0);
                break;
            case 1:
                visitor.visitInsn(ICONST_1);
                break;
            case 2:
                visitor.visitInsn(ICONST_2);
                break;
            case 3:
                visitor.visitInsn(ICONST_3);
                break;
            case 4:
                visitor.visitInsn(ICONST_4);
                break;
            case 5:
                visitor.visitInsn(ICONST_5);
                break;
            default:
                visitor.visitIntInsn(BIPUSH, expression.getJChar());
                break;
        }
    }

    public static void generate(TypedBinary expression, MethodVisitor visitor, Context context) {
        switch(expression.getOperator()) {
            case PLUS:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(IADD);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            case MINUS:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(ISUB);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            case MULTIPLICATION:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(IMUL);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            case DIVISION:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(IDIV);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            case MODULO:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(IREM);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            default:
                generateBinary(expression, visitor, context);
                break;
        }
    }

    public static void generateBinary(TypedBinary expression, MethodVisitor visitor, Context context) {
        Label label = new Label();
        Label skip = new Label();
        Label finish = new Label();
        switch(expression.getOperator()) {
            case LESSOREQUAL:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getExpression().getObjectType()) &&
                        isInteger(expression.getExpression2().getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPGT, label);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            case LESSTHAN:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getExpression().getObjectType()) &&
                        isInteger(expression.getExpression2().getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPGE, label);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            case GREATEROREQUAL:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getExpression().getObjectType()) &&
                        isInteger(expression.getExpression2().getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPLT, label);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            case GREATERTHAN:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getExpression().getObjectType()) &&
                        isInteger(expression.getExpression2().getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPLE, label);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            case EQUALS:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getExpression().getObjectType()) &&
                        isInteger(expression.getExpression2().getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPNE, label);
                }
                else {
                    visitor.visitJumpInsn(IF_ACMPNE, label);
                }
                break;
            case NOTEQUALS:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getExpression().getObjectType()) &&
                        isInteger(expression.getExpression2().getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPEQ, label);
                }
                else {
                    visitor.visitJumpInsn(IF_ACMPEQ, label);
                }
                break;
            case AND:
                expression.getExpression().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFEQ, label);
                expression.getExpression2().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFEQ, label);
                break;
            case OR:
                expression.getExpression().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFNE, skip);
                expression.getExpression2().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFEQ, label);
                break;
            case XOR:
                expression.getExpression().generateByteCode(visitor, context);
                Label firstTrue = new Label();
                visitor.visitJumpInsn(IFNE, firstTrue);
                expression.getExpression2().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFEQ, label);
                visitor.visitJumpInsn(GOTO, skip);
                visitor.visitLabel(firstTrue);
                expression.getExpression2().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFNE, label);
                break;
            default:
                throw new NotImplementedYetException();
        }
        visitor.visitLabel(skip);
        visitor.visitInsn(ICONST_1);
        visitor.visitJumpInsn(GOTO, finish);
        visitor.visitLabel(label);
        visitor.visitInsn(ICONST_0);
        visitor.visitJumpInsn(GOTO, finish);
        visitor.visitLabel(finish);
    }

    public static void generate(TypedUnary expression, MethodVisitor visitor, Context context) {
        Label label = new Label();
        Label finish = new Label();
        switch(expression.getOperator()) {
            case NEGATION:
                if(ObjectType.BoolType.equals(expression.getObjectType())) {
                    expression.getExpression().generateByteCode(visitor, context);
                    visitor.visitJumpInsn(IFEQ, label);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            case PLUS:
                //The Unary Plus operator has no effect
                break;
            case MINUS:
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(INEG);
                }
                else {
                    throw new InvalidOperationException(expression.getOperator());
                }
                break;
            default:
                throw new NotImplementedYetException();
        }
        visitor.visitInsn(ICONST_0);
        visitor.visitLabel(label);
        visitor.visitInsn(ICONST_1);
        visitor.visitLabel(finish);
    }


    public static void generate(TypedLocalOrFieldVar expression, MethodVisitor visitor, Context context) {
        if(context.getLocalVar().containsKey(expression.getName())) {
            visitor.visitVarInsn(getOpcodeLoad(expression.getObjectType()),
                    context.getLocalVar().get(expression.getName()));
        }
        else if(context.getLocalFields().contains(expression.getName())) {
            visitor.visitVarInsn(ALOAD, 0);
            visitor.visitFieldInsn(GETFIELD, context.getClassName(), expression.getName(),
                    expression.getObjectType().getByteCodeName());
        }
        else if(context.getStaticFields().contains(expression.getName())) {
            visitor.visitFieldInsn(GETSTATIC, context.getClassName(), expression.getName(),
                    expression.getObjectType().getByteCodeName());
        }
    }

    public static void generate(TypedInstVar expression, MethodVisitor visitor, Context context) {
        expression.getExpression().generateByteCode(visitor, context);
        visitor.visitFieldInsn(GETFIELD, expression.getExpression().getObjectType().getName(),
                expression.getName(),
                expression.getObjectType().getByteCodeName());
    }

    public static void generate(TypedMethodCallExpression expression, MethodVisitor visitor, Context context) {
        generateMethodCall(expression.getName(), expression.getObjectType(), expression.getObject(),
                expression.getParameters(), visitor, context);
    }

    public static void generate(TypedNewExpression expression, MethodVisitor visitor, Context context) {
        GeneratorUtils.generateNew(expression.getNewType(), expression.getParameters(), visitor, context);
    }

    public static void generate(TypedAssignExpression expression, MethodVisitor visitor, Context context) {
        generateAssign(expression.getExpression1(), expression.getExpression2(), visitor, context);
        expression.getExpression1().generateByteCode(visitor, context);
    }

    public static void generate(TypedSuper expression, MethodVisitor visitor, Context context) {
        throw new NotImplementedYetException();
    }

    public static void generate(TypedExpression expression, MethodVisitor visitor, Context context) {
        throw new NotImplementedYetException();
    }
}
