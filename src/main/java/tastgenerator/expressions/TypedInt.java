package tastgenerator.expressions;

import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedInt extends TypedExpression
{
    private int jint;

    public TypedInt(String jint)
    {
        this.jint = Integer.parseInt(jint);
        this.objectType = ObjectType.IntType;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}