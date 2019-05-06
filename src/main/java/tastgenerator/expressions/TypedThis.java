package tastgenerator.expressions;

import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;

public class TypedThis extends TypedExpression
{

    @Override
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
