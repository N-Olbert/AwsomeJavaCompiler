package bytecodegenerator;

import astgenerator.expressions.LocalOrFieldVar;
import common.Modifier;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import tastgenerator.Method;
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

import javax.tools.OptionChecker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Generator {
    public static List<ClassWriter> generate(TypedProgram program) {
        return program.getClasses().stream().map(Generator::generate).collect(Collectors.toList());
    }

    public static ClassWriter generate(TypedClass clazz) {
        ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(Opcodes.V1_4, Opcodes.ACC_PUBLIC,
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
        writer.visitField(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(), declaration.getName(), declaration.getVariableType().getName(), null, null);
    }


    public static void generate(TypedMethodDeclaration declaration, ClassWriter writer, Context context) {
        MethodVisitor visitor = writer.visitMethod(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(), declaration.getName(), generate(declaration.getParams()) + declaration.getReturnType().getName(), null, null);
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
        statement.getExp().generateByteCode(visitor, context.clone());
        switch(statement.getExp().getObjectType().getName()) {
            case "I":
                visitor.visitInsn(Opcodes.IRETURN);
                break;
            case "V":
                visitor.visitInsn(Opcodes.RETURN);
                break;
        }
    }

    public static void generate(TypedLocalOrFieldVar expression, MethodVisitor visitor, Context context) {
        if(context.getLocalVar().containsKey(expression.getName())) {
            visitor.visitVarInsn(Opcodes.ILOAD, context.getLocalVar().get(expression.getName()));
        }
        else if(context.getLocalFields().contains(expression.getName())) {
            visitor.visitVarInsn(Opcodes.ALOAD, 0);
            visitor.visitFieldInsn(Opcodes.GETFIELD, context.getClassName(), expression.getName(), expression.getObjectType().getName());
        }
        else if(context.getStaticFields().contains(expression.getName())) {
            visitor.visitFieldInsn(Opcodes.GETSTATIC, context.getClassName(), expression.getName(), expression.getObjectType().getName());
        }
    }

    public static void generate(TypedInt expression, MethodVisitor visitor, Context context) {
        switch (expression.getJint()) {
            case -1:
                visitor.visitInsn(Opcodes.ICONST_M1);
                break;
            case 0:
                visitor.visitInsn(Opcodes.ICONST_0);
                break;
            case 1:
                visitor.visitInsn(Opcodes.ICONST_1);
                break;
            case 2:
                visitor.visitInsn(Opcodes.ICONST_2);
                break;
            case 3:
                visitor.visitInsn(Opcodes.ICONST_3);
                break;
            case 4:
                visitor.visitInsn(Opcodes.ICONST_4);
                break;
            case 5:
                visitor.visitInsn(Opcodes.ICONST_5);
                break;
            default:
                visitor.visitIntInsn(Opcodes.BIPUSH, expression.getJint());
                break;
        }
    }

    public static void generate(TypedAssignStatement statement, MethodVisitor visitor, Context context) {
        statement.getExpression1().generateByteCode(visitor, context);
        statement.getExpression2().generateByteCode(visitor, context);
        if(statement.getExpression1() instanceof TypedInstVar) {
            visitor.visitFieldInsn(Opcodes.PUTFIELD, context.getClassName(), ((TypedInstVar) statement.getExpression1()).getName(), statement.getExpression2().getObjectType().getName());
        }
    }

    public static void generate(TypedThis expression, MethodVisitor visitor, Context context) {
        visitor.visitVarInsn(Opcodes.ALOAD, 0);
    }

    public static void generate(TypedInstVar expression, MethodVisitor visitor, Context context) {
        expression.getExpression().generateByteCode(visitor, context);

    }

    public static void generate(TypedStatement statement, MethodVisitor visitor, Context context) {
        throw new RuntimeException("Not implemented yet!");
    }

    public static void generate(TypedExpression expression, MethodVisitor visitor, Context context) {
        throw new RuntimeException("Not implemented yet!");
    }
}
