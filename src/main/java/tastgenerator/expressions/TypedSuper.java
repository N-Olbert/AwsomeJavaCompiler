package tastgenerator.expressions;

import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedSuper extends TypedExpression
{

    @Override
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {
        Generator.generate(this, visitor, localVar);
    }
}
