package tastgenerator.expressions;

import common.ObjectType;

public class TypedNull extends TypedExpression
{
    public TypedNull()
    {
        this.objectType = ObjectType.NullType;
    }
}
