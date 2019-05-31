package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedInt extends TypedExpression
{
    private int jint;

    public TypedInt(String jint)
    {
        this.jint = Integer.parseInt(jint);
        this.objectType = ObjectType.IntType;
    }

    public int getJint() {
        return jint;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        if (!super.equals(o))
        {
            return false;
        }

        TypedInt typedInt = (TypedInt) o;

        return super.equals(o) && jint == typedInt.jint;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + jint;
        return result;
    }
}