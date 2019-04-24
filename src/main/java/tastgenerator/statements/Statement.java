package tastgenerator.statements;

import tastgenerator.generalelements.ObjectType;

public abstract class Statement
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
