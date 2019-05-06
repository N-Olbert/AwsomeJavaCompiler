package astgenerator.generalelements;

import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

public class MethodParameter extends GeneralThing
{
    private ObjectType type;
    private String name;

    public MethodParameter(ObjectType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public TypedGeneralThing toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
