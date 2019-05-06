package bytecodegenerator;

import org.objectweb.asm.MethodVisitor;

public interface GenerateByteCodeExpression {
    void generateByteCode(MethodVisitor visitor);
}
