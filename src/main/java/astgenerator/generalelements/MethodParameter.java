package astgenerator.generalelements;

import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

import java.util.Objects;

public class MethodParameter extends GeneralThing
{
    private ObjectType type;
    private String name;

    public MethodParameter(ObjectType type, String name) {
        this.type = type;
        this.name = name;
    }

    public ObjectType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public TypedGeneralThing toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodParameter that = (MethodParameter) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
