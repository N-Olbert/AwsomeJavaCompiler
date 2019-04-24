package tastgenerator.expressions;

import tastgenerator.generalelements.ObjectType;

public class LocalOrFieldVar extends Expression
{
    private String name;
    public LocalOrFieldVar(ObjectType objectType,String name){
        this.objectType = objectType;
        this.name = name;
    }

    public ObjectType getObjectType()
    {
        return objectType;
    }

    public String getName()
    {
        return name;
    }

}
