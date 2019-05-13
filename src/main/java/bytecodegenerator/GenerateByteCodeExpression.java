package bytecodegenerator;

import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public interface GenerateByteCodeExpression {
    void generateByteCode(MethodVisitor visitor, Context context);
}
