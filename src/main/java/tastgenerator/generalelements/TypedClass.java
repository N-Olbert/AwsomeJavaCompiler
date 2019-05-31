package tastgenerator.generalelements;

import common.ObjectType;

import java.util.List;

public class TypedClass extends TypedGeneralThing
{
    private ObjectType classType;
    private List<TypedFieldDeclaration> fields;
    private List<TypedMethodDeclaration> methods;

    public TypedClass(ObjectType classType, List<TypedFieldDeclaration> fields, List<TypedMethodDeclaration> methods)
    {
        this.classType = classType;
        this.fields = fields;
        this.methods = methods;
        this.objectType = classType;
    }

    public ObjectType getClassType()
    {
        return classType;
    }

    public List<TypedFieldDeclaration> getFields()
    {
        return fields;
    }

    public List<TypedMethodDeclaration> getMethods()
    {
        return methods;
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

        TypedClass that = (TypedClass) o;

        if (classType != null ? !classType.equals(that.classType) : that.classType != null)
        {
            return false;
        }
        if (fields != null ? !fields.equals(that.fields) : that.fields != null)
        {
            return false;
        }
        return methods != null ? methods.equals(that.methods) : that.methods == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (classType != null ? classType.hashCode() : 0);
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        result = 31 * result + (methods != null ? methods.hashCode() : 0);
        return result;
    }
}
