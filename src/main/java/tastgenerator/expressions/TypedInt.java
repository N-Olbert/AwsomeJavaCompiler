package tastgenerator.expressions;

import common.ObjectType;

public class TypedInt extends TypedExpression
{
    private int jint;

    public TypedInt(String jint)
    {
        this.jint = Integer.parseInt(jint);
        this.objectType = ObjectType.IntType;
    }
}