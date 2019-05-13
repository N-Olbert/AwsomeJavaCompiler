package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedThis extends TypedExpression
{

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
