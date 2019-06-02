package bytecodegenerator.interfaces;

import bytecodegenerator.Context;
import org.objectweb.asm.MethodVisitor;

public interface ByteCodeGeneratable {
    void generateByteCode(MethodVisitor visitor, Context context);
}
