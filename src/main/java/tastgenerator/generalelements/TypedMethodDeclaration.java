package tastgenerator.generalelements;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import tastgenerator.statements.TypedBlock;

import java.util.List;

public class TypedMethodDeclaration extends TypedGeneralThing
{
    private AccessModifier accessModifier;
    private Modifier modifier;
    private ObjectType returnType;
    private String name;
    private List<TypedMethodParameter> params;
    private TypedBlock stmt;

    public TypedMethodDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType returnType,
                                  String name, List<TypedMethodParameter> params, TypedBlock stmt) {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.stmt = stmt;
        this.objectType = returnType;
    }

    public ObjectType getReturnType()
    {
        return returnType;
    }

    public String getName()
    {
        return name;
    }

    public List<TypedMethodParameter> getParams()
    {
        return params;
    }

    public TypedBlock getStmt()
    {
        return stmt;
    }

    public AccessModifier getAccessModifier() { return accessModifier; }

    public Modifier getModifier() { return modifier; }

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

        TypedMethodDeclaration that = (TypedMethodDeclaration) o;

        if (accessModifier != that.accessModifier)
        {
            return false;
        }
        if (modifier != that.modifier)
        {
            return false;
        }
        if (returnType != null ? !returnType.equals(that.returnType) : that.returnType != null)
        {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null)
        {
            return false;
        }
        if (params != null ? !params.equals(that.params) : that.params != null)
        {
            return false;
        }
        return stmt != null ? stmt.equals(that.stmt) : that.stmt == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (accessModifier != null ? accessModifier.hashCode() : 0);
        result = 31 * result + (modifier != null ? modifier.hashCode() : 0);
        result = 31 * result + (returnType != null ? returnType.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (params != null ? params.hashCode() : 0);
        result = 31 * result + (stmt != null ? stmt.hashCode() : 0);
        return result;
    }
}
