package tastgenerator.generalelements;

import common.ObjectType;

public class TypedMethodParameter extends TypedGeneralThing
{
    private String name;

    public TypedMethodParameter(ObjectType type, String name) {
        this.objectType = type;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
