package tastgenerator.expressions;

import bytecodegenerator.GenerateByteCodeExpression;
import common.ObjectType;

public abstract class TypedExpression implements GenerateByteCodeExpression
{
    protected ObjectType objectType;

    public ObjectType getObjectType()
    {
        return objectType;
    }

    public void setObjectType(ObjectType objectType)
    {
        this.objectType = objectType;
    }
}
