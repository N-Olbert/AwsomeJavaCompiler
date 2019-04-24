package tastgenerator.expressions;

import tastgenerator.generalelements.ObjectType;

public abstract class Expression
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
