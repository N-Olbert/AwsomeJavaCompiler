package common;

import org.objectweb.asm.ClassWriter;
import tastgenerator.generalelements.TypedProgram;

import java.util.List;

public interface BytecodeGenerator {
    List<ClassWriter> generate(TypedProgram program);
}
