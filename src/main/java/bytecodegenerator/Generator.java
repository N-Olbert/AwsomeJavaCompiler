package bytecodegenerator;

import common.Modifier;
import common.ObjectType;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.generalelements.TypedClass;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedReturn;

import java.util.List;
import java.util.stream.Collectors;

import static bytecodegenerator.GeneratorUtils.*;
import static org.objectweb.asm.Opcodes.*;

/**
 * The Generator class contains all generators of the general elements of the TAST
 *
 * @author Nico Dreher
 */
public abstract class Generator {
    /**
     * Generates the bytecode of a {@link TypedProgram}
     *
     * @param program The {@link TypedProgram} to generate the bytecode
     *
     * @return A list of the generated {@link ClassWriter}
     */
    public static List<ClassWriter> generate(TypedProgram program) {
        return program.getClasses().stream().map(Generator::generate).collect(Collectors.toList());
    }

    /**
     * Generates a {@link ClassWriter} from a {@link TypedClass}
     *
     * @param clazz The {@link TypedClass} to generate the bytecode
     *
     * @return The {@link ClassWriter} with the bytecode
     */
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


    /**
     * Generates the bytecode of a field
     *
     * @param declaration The declaration of the field
     * @param writer      The ClassWriter to generate the field
     * @param context     The {@link Context} of the current scope
     */
    public static void generate(TypedFieldDeclaration declaration, ClassWriter writer, Context context) {
        if(Modifier.STATIC.equals(declaration.getModifier())) {
            context.getStaticFields().add(declaration.getName());
        }
        else {
            context.getLocalFields().add(declaration.getName());
        }
        writer.visitField(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(),
                declaration.getName(), declaration.getVariableType().getByteCodeName(), null, null);
    }

    /**
     * Generate the bytecode of a method
     *
     * @param declaration The declaration of the method
     * @param writer      The ClassWriter to generate the method
     * @param context     The {@link Context} of the current scope
     */
    public static void generate(TypedMethodDeclaration declaration, ClassWriter writer, Context context) {
        String name = declaration.getName();
        if(declaration.getName().equals(context.getClassName())) {
            name = "<init>";
        }
        String signature = "()";
        if(declaration.getParams() != null) {
            signature =
                    generateTypeSignature(declaration.getParams().stream().map(param -> param.getObjectType())
                            .collect(Collectors.toList()));
        }
        MethodVisitor visitor =
                writer.visitMethod(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(),
                        name, signature + declaration.getReturnType().getByteCodeName(), null,
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
        declaration.getStmt().generateByteCode(visitor, context.clone());
        new TypedReturn(null, ObjectType.VoidType).generateByteCode(visitor, context.clone());
        visitor.visitMaxs(0, 0);
        visitor.visitEnd();
    }
}
