package bytecodegenerator;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.generalelements.TypedClass;

import java.util.HashMap;
import java.util.Map;

public interface GenerateByteCodeStatement {
    void generateByteCode(MethodVisitor visitor, Context context);
}
