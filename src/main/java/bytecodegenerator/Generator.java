package bytecodegenerator;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import tastgenerator.expressions.TypedExpression;
import tastgenerator.expressions.TypedInt;
import tastgenerator.expressions.TypedLocalOrFieldVar;
import tastgenerator.generalelements.TypedClass;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedStatement;

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

        if(clazz.getFields() != null) {
            clazz.getFields().forEach(declaration -> generate(declaration, cw));
        }
        if(clazz.getMethods() != null) {
            clazz.getMethods().forEach(declaration -> generate(declaration, cw));
        }
        cw.visitEnd();
        return cw;
    }


    public static void generate(TypedFieldDeclaration declaration, ClassWriter writer) {
        writer.visitField(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(), declaration.getName(), declaration.getVariableType().getName(), null, null);
    }


    public static void generate(TypedMethodDeclaration declaration, ClassWriter writer) {
        MethodVisitor visitor = writer.visitMethod(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(), declaration.getName(), generate(declaration.getParams()) + declaration.getReturnType().getName(), null, null);
        Map<String, Integer> localVar = new HashMap<>();
        if(declaration.getParams() != null) {
            declaration.getParams().forEach(param -> {
                localVar.put(param.getName(), localVar.size());
                visitor.visitParameter(param.getName(), 0);
            });
        }
        visitor.visitCode();
        generate(declaration.getStmt(), visitor, localVar);
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

    public static void generate(TypedBlock block, MethodVisitor visitor, Map<String, Integer> localVar) {
        if(block.getBlockedStatements() != null) {
            block.getBlockedStatements().forEach(statement -> statement.generateByteCode(visitor, new HashMap<>(localVar)));
        }
    }

    public static void generate(TypedReturn statement, MethodVisitor visitor, Map<String, Integer> localVar) {
        statement.getExp().generateByteCode(visitor, new HashMap<>(localVar));
        visitor.visitInsn(Opcodes.IRETURN);
    }

    public static void generate(TypedLocalOrFieldVar expression, MethodVisitor visitor, Map<String, Integer> localVar) {
        visitor.visitVarInsn(Opcodes.ILOAD, localVar.get(expression.getName()));
    }

    public static void generate(TypedInt expression, MethodVisitor visitor, Map<String, Integer> localVar) {
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

    public static void generate(TypedStatement statement, MethodVisitor visitor, Map<String, Integer> localVar) {
        throw new RuntimeException("Not implemented yet!");
    }

    public static void generate(TypedExpression expression, MethodVisitor visitor, Map<String, Integer> localVar) {
        throw new RuntimeException("Not implemented yet!");
    }




}
