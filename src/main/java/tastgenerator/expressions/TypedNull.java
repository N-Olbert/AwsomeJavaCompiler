package tastgenerator.expressions;

import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedNull extends TypedExpression
{
    public TypedNull()
    {
        this.objectType = ObjectType.NullType;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
