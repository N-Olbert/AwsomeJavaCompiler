package bytecodegenerator;

import common.Modifier;
import common.ObjectType;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;
import tastgenerator.expressions.TypedInstVar;
import tastgenerator.expressions.TypedInt;
import tastgenerator.expressions.TypedLocalOrFieldVar;
import tastgenerator.expressions.TypedThis;
import tastgenerator.generalelements.TypedClass;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedAssignStatement;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedStatement;

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
                        name, generate(declaration.getParams()) + declaration.getReturnType().getName(), null, null);
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
            typedMethodParameters.forEach(param -> builder.append(param.getObjectType().getName()));
        }
        builder.append(')');
        return builder.toString();
    }

    public static void generate(TypedBlock block, MethodVisitor visitor, Context context) {
        if(block.getBlockedStatements() != null) {
            block.getBlockedStatements().forEach(statement -> statement.generateByteCode(visitor, context.clone()));
        }
    }

    public static void generate(TypedReturn statement, MethodVisitor visitor, Context context) {
        switch(statement.getObjectType().getName()) {
            case "I":
                statement.getExp().generateByteCode(visitor, context.clone());
                visitor.visitInsn(IRETURN);
                break;
            case "V":
                visitor.visitInsn(RETURN);
                break;
            default:
                visitor.visitInsn(ARETURN);
        }
    }

    public static void generate(TypedLocalOrFieldVar expression, MethodVisitor visitor, Context context) {
        if(context.getLocalVar().containsKey(expression.getName())) {
            visitor.visitVarInsn(ILOAD, context.getLocalVar().get(expression.getName()));
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
    }

    public static void generate(TypedThis expression, MethodVisitor visitor, Context context) {
        visitor.visitVarInsn(ALOAD, 0);
    }

    public static void generate(TypedInstVar expression, MethodVisitor visitor, Context context) {
        expression.getExpression().generateByteCode(visitor, context);
        visitor.visitFieldInsn(GETFIELD, expression.getExpression().getObjectType().getName(), expression.getName(),
                expression.getObjectType().getName());
    }

    public static void generate(TypedStatement statement, MethodVisitor visitor, Context context) {
        throw new RuntimeException("Not implemented yet!");
    }

    public static void generate(TypedExpression expression, MethodVisitor visitor, Context context) {
        throw new RuntimeException("Not implemented yet!");
    }
}
