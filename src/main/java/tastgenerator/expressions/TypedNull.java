package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedNull extends TypedExpression
{
    public TypedNull()
    {
        this.objectType = ObjectType.NullType;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }

    @Override
    public boolean equals(Object o)
    {
        return super.equals(o) && o instanceof TypedNull;
    }
}
