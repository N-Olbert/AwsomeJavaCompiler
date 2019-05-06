package tastgenerator.generalelements;

import common.ObjectType;

public class TypedMethodParameter extends TypedGeneralThing
{
    private ObjectType type;
    private String name;

    public TypedMethodParameter(ObjectType type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public ObjectType getType()
    {
        return type;
    }
}
