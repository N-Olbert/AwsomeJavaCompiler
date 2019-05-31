package tastgenerator.generalelements;

import java.util.List;

public class TypedProgram extends TypedGeneralThing
{
    private List<TypedClass> classes;

    public TypedProgram(List<TypedClass> classes) {
        this.classes = classes;
    }

    public List<TypedClass> getClasses()
    {
        return classes;
    }

    public void setClasses(List<TypedClass> classes)
    {
        this.classes = classes;
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

        TypedProgram that = (TypedProgram) o;

        return classes != null ? classes.equals(that.classes) : that.classes == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (classes != null ? classes.hashCode() : 0);
        return result;
    }
}
