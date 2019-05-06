package bytecodegenerator;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import tastgenerator.generalelements.TypedClass;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;

import java.util.List;
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
        return cw;
    }


    public static void generate(TypedFieldDeclaration declaration, ClassWriter writer) {
        writer.visitField(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(), declaration.getName(), declaration.getVariableType().getName(), null, null);
    }

    public static void generate(TypedMethodDeclaration declaration, ClassWriter writer) {
        writer.visitMethod(declaration.getAccessModifier().getCode() | declaration.getModifier().getCode(), declaration.getName(), generate(declaration.getParams()) + declaration.getReturnType().getName(), null, null);
    }

    public static String generate(List<TypedMethodParameter> typedMethodParameters) {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        typedMethodParameters.forEach(param -> builder.append(param.getObjectType().getName()));
        builder.append(')');
        return builder.toString();
    }




}
