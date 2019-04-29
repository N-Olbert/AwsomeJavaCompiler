package astgenerator.generalelements;

import common.ObjectType;

public class MethodParameter extends GeneralThing
{
    private ObjectType type;
    private String name;

    public MethodParameter(ObjectType type, String name) {
        this.type = type;
        this.name = name;
    }
}
