package bytecodegenerator;

import common.Modifier;
import common.ObjectType;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedBinary;
import tastgenerator.expressions.TypedExpression;
import tastgenerator.expressions.TypedInstVar;
import tastgenerator.expressions.TypedInt;
import tastgenerator.expressions.TypedLocalOrFieldVar;
import tastgenerator.expressions.TypedMethodCallExpression;
import tastgenerator.expressions.TypedNewExpression;
import tastgenerator.expressions.TypedThis;
import tastgenerator.expressions.TypedUnary;
import tastgenerator.generalelements.TypedClass;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedAssignStatement;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedIfElse;
import tastgenerator.statements.TypedLocalVarDeclaration;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedStatement;
import tastgenerator.statements.TypedWhile;

import java.util.List;
import java.util.stream.Collectors;

import static org.objectweb.asm.Opcodes.*;

public abstract class Generator {
    public static List<ClassWriter> generate(TypedProgram program) {
        return program.getClasses().stream().map(Generator::generate).collect(Collectors.toList());
    }

    public static ClassWriter generate(TypedClass clazz) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(V1_4, ACC_PUBLIC,
                clazz.getClassType().getName(),
                null, "java/lang/Object", null);
        Context context = new Context(clazz.getClassType().getName());
        if(clazz.getFields() != null) {
            clazz.getFields().forEach(declaration -> generate(declaration, cw, context));
        }
        if(clazz.getMethods() != null) {
            clazz.getMethods().forEach(declaration -> generate(declaration, cw, context.clone()));
        }
        cw.visitEnd();
        return cw;
    }


    public static void generate(TypedFieldDeclaration declaration, ClassWriter writer, Context context) {
        if(Modifier.STATIC.equals(declaration.getModifier())) {
            context.getStaticFields().add(declaration.getName());
        }
        else {
            context.getLocalFields().add(declaration.getName());
        }
        writer.visitField(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(),
                declaration.getName(), declaration.getVariableType().getName(), null, null);
    }


    public static void generate(TypedMethodDeclaration declaration, ClassWriter writer, Context context) {
        String name = declaration.getName();
        if(declaration.getName().equals(context.getClassName())) {
            name = "<init>";
        }
        MethodVisitor visitor =
                writer.visitMethod(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(),
                        name, generate(declaration.getParams()) + declaration.getReturnType().getByteCodeName(), null,
                        null);
        if(name.equals("<init>")) {
            visitor.visitVarInsn(ALOAD, 0);
            visitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        }
        if(!Modifier.STATIC.equals(declaration.getModifier())) {
            context.getLocalVar().put("this", 0);
        }
        if(declaration.getParams() != null) {
            declaration.getParams().forEach(param -> {
                context.getLocalVar().put(param.getName(), context.getLocalVar().size());
                visitor.visitParameter(param.getName(), 0);
            });
        }
        visitor.visitCode();
        generate(declaration.getStmt(), visitor, context.clone());
        new TypedReturn(null, ObjectType.VoidType).generateByteCode(visitor, context.clone());
        visitor.visitMaxs(0, 0);
        visitor.visitEnd();
    }

    public static String generate(List<TypedMethodParameter> typedMethodParameters) {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        if(typedMethodParameters != null) {
            typedMethodParameters.forEach(param -> builder.append(param.getObjectType().getByteCodeName()));
        }
        builder.append(')');
        return builder.toString();
    }

    public static void generate(TypedBlock block, MethodVisitor visitor, Context context) {
        if(block.getBlockedStatements() != null) {
            block.getBlockedStatements().forEach(statement -> statement.generateByteCode(visitor, context));
        }
    }

    public static void generate(TypedReturn statement, MethodVisitor visitor, Context context) {
        switch(statement.getObjectType().getName()) {

            case "C": //Fall Trough
            case "Z":
            case "I":
                statement.getExp().generateByteCode(visitor, context);
                visitor.visitInsn(IRETURN);
                break;
            case "V":
                visitor.visitInsn(RETURN);
                break;
            default:
                statement.getExp().generateByteCode(visitor, context);
                visitor.visitInsn(ARETURN);
        }
    }

    public static void generate(TypedLocalOrFieldVar expression, MethodVisitor visitor, Context context) {
        if(context.getLocalVar().containsKey(expression.getName())) {
            visitor.visitVarInsn(getOpcodeLoad(expression.getObjectType()),
                    context.getLocalVar().get(expression.getName()));
        }
        else if(context.getLocalFields().contains(expression.getName())) {
            visitor.visitVarInsn(ALOAD, 0);
            visitor.visitFieldInsn(GETFIELD, context.getClassName(), expression.getName(),
                    expression.getObjectType().getName());
        }
        else if(context.getStaticFields().contains(expression.getName())) {
            visitor.visitFieldInsn(GETSTATIC, context.getClassName(), expression.getName(),
                    expression.getObjectType().getName());
        }
    }

    public static int getOpcodeLoad(ObjectType type) {
        switch(type.getName()) {
            case "I"://Fall trough
            case "C":
            case "Z":
                return ILOAD;
            default:
                return ALOAD;
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

    public static void generate(TypedAssignStatement statement, MethodVisitor visitor, Context context) {
        if(statement.getExpression1() instanceof TypedInstVar) {
            ((TypedInstVar) statement.getExpression1()).getExpression().generateByteCode(visitor, context);
            statement.getExpression2().generateByteCode(visitor, context);
            visitor.visitFieldInsn(PUTFIELD, context.getClassName(),
                    ((TypedInstVar) statement.getExpression1()).getName(),
                    statement.getExpression2().getObjectType().getName());
        }
        else if(statement.getExpression1() instanceof TypedLocalOrFieldVar) {
            TypedLocalOrFieldVar lofv = (TypedLocalOrFieldVar) statement.getExpression1();
            if(context.getLocalVar().containsKey(lofv.getName())) {
                statement.getExpression2().generateByteCode(visitor, context);
                switch(statement.getExpression1().getObjectType().getName()) {
                    case "I":
                        visitor.visitVarInsn(ISTORE, context.getLocalVar().get(lofv.getName()));
                        break;
                    default:
                        throw new RuntimeException("Not implemented yet!");
                }
            }
            else {
                throw new RuntimeException("Not implemented yet!");
            }
        }
        else {
            throw new RuntimeException("Not implemented yet!");
        }
    }

    public static void generate(TypedThis expression, MethodVisitor visitor, Context context) {
        visitor.visitVarInsn(ALOAD, 0);
    }

    public static void generate(TypedInstVar expression, MethodVisitor visitor, Context context) {
        expression.getExpression().generateByteCode(visitor, context);
        visitor.visitFieldInsn(GETFIELD, expression.getExpression().getObjectType().getName(),
                expression.getName(),
                expression.getObjectType().getName());
    }

    public static void generate(TypedIfElse expression, MethodVisitor visitor, Context context) {
        Label l0 = new Label();
        Label finish = new Label();
        expression.getCondition().generateByteCode(visitor, context);
        visitor.visitJumpInsn(IFEQ, l0);
        expression.getThen().generateByteCode(visitor, context.clone());
        visitor.visitJumpInsn(GOTO, finish);
        visitor.visitLabel(l0);
        expression.getOtherwise().generateByteCode(visitor, context.clone());
        visitor.visitJumpInsn(GOTO, finish);
        visitor.visitLabel(finish);
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
                    throw new RuntimeException("Not implemented yet!");
                }
                break;
            case MINUS:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(ISUB);
                }
                else {
                    throw new RuntimeException("Not implemented yet!");
                }
                break;
            case MULTIPLICATION:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(IMUL);
                }
                else {
                    throw new RuntimeException("Not implemented yet!");
                }
                break;
            case DIVISION:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(IDIV);
                }
                else {
                    throw new RuntimeException("Not implemented yet!");
                }
                break;
            case MODULO:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitInsn(IREM);
                }
                else {
                    throw new RuntimeException("Not implemented yet!");
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
                if(isInteger(expression.getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPGT, label);
                }
                else {
                    throw new RuntimeException("Not implemented yet!");
                }
                break;
            case LESSTHAN:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPGE, label);
                }
                else {
                    throw new RuntimeException("Not implemented yet!");
                }
                break;
            case GREATEROREQUAL:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPLT, label);
                }
                else {
                    throw new RuntimeException("Not implemented yet!");
                }
                break;
            case GREATERTHAN:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPLE, label);
                }
                else {
                    throw new RuntimeException("Not implemented yet!");
                }
                break;
            case EQUALS:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
                    visitor.visitJumpInsn(IF_ICMPNE, label);
                }
                else {
                    visitor.visitJumpInsn(IF_ACMPNE, label);
                }
                break;
            case NOTEQUALS:
                expression.getExpression().generateByteCode(visitor, context);
                expression.getExpression2().generateByteCode(visitor, context);
                if(isInteger(expression.getObjectType())) {
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
            case OR:
                expression.getExpression().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFNE, skip);
                expression.getExpression2().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFEQ, label);
            case XOR:
                expression.getExpression().generateByteCode(visitor, context);
                Label firstTrue = new Label();
                visitor.visitJumpInsn(IFNE, firstTrue);
                expression.getExpression2().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFEQ, label);
                visitor.visitLabel(firstTrue);
                expression.getExpression2().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFNE, label);
            default:
                throw new RuntimeException(expression.getOperator() + " Not implemented yet!");
        }
        visitor.visitLabel(skip);
        visitor.visitInsn(ICONST_1);
        visitor.visitJumpInsn(GOTO, finish);
        visitor.visitLabel(label);
        visitor.visitInsn(ICONST_0);
        visitor.visitJumpInsn(GOTO, finish);
        visitor.visitLabel(finish);
    }

    public static void generate(TypedMethodCallExpression expression, MethodVisitor visitor, Context context) {
        String type =
                "(" + getType(expression.getParameters()) + ")" + expression.getObjectType().getByteCodeName();
        expression.getObject().generateByteCode(visitor, context);
        expression.getParameters().forEach(exp -> exp.generateByteCode(visitor, context));
        visitor.visitMethodInsn(INVOKEVIRTUAL, expression.getObject().getObjectType().getName(),
                expression.getName(), type, false);
    }

    public static void generate(TypedLocalVarDeclaration expression, MethodVisitor visitor, Context context) {
        context.getLocalVar().put(expression.getName(), context.getLocalVar().size());
    }

    public static String getType(List<TypedExpression> expressions) {
        StringBuilder builder = new StringBuilder();
        expressions.forEach(exp -> builder.append(exp.getObjectType().getByteCodeName()));
        return builder.toString();
    }

    public static void generate(TypedWhile statement, MethodVisitor visitor, Context context) {
        Label finish = new Label();
        Label l0 = new Label();
        visitor.visitLabel(l0);
        statement.getExp().generateByteCode(visitor, context);
        visitor.visitJumpInsn(IFEQ, finish);
        statement.getStmt().generateByteCode(visitor, context.clone());
        visitor.visitJumpInsn(GOTO, l0);
        visitor.visitLabel(finish);
    }

    public static void generate(TypedNewExpression expression, MethodVisitor visitor, Context context) {
        visitor.visitTypeInsn(NEW, expression.getNewType().getName());
        visitor.visitInsn(DUP);
        expression.getParameters().forEach(param -> param.generateByteCode(visitor, context));
        visitor.visitMethodInsn(INVOKESPECIAL, expression.getNewType().getName(), "<init>",
                "(" + getType(expression.getParameters()) + ")V", false);
    }

    public static void generate(TypedUnary expression, MethodVisitor visitor, Context context) {
        Label label = new Label();
        Label finish = new Label();
        switch(expression.getOperator()) {
            case NEGATION:
                expression.getExpression().generateByteCode(visitor, context);
                visitor.visitJumpInsn(IFEQ, label);
                break;
            default:
                throw new RuntimeException("Not implemented yet!");
        }
        visitor.visitInsn(ICONST_0);
        visitor.visitLabel(label);
        visitor.visitInsn(ICONST_1);
        visitor.visitLabel(finish);
    }

    public static boolean isInteger(ObjectType type) {
        return "I".equals(type.getName()) || "C".equals(type.getName()) || "Z".equals(type.getName());
    }

    public static void generate(TypedStatement statement, MethodVisitor visitor, Context context) {
        throw new RuntimeException("Not implemented yet!");
    }

    public static void generate(TypedExpression expression, MethodVisitor visitor, Context context) {
        throw new RuntimeException("Not implemented yet!");
    }
}
