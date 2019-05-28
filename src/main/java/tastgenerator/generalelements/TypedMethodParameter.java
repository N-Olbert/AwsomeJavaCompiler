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

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        if (!super.equals(o))
        {
            return false;
        }

        TypedMethodParameter that = (TypedMethodParameter) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
