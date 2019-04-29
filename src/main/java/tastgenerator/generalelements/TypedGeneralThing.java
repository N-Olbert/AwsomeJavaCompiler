package tastgenerator.generalelements;

import common.ObjectType;

public abstract class TypedGeneralThing
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
