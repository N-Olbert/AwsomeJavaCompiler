package tastgenerator.expressions;

import common.ObjectType;

public abstract class TypedExpression
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
