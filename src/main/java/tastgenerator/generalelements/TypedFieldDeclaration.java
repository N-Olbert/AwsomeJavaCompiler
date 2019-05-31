package tastgenerator.generalelements;

import astgenerator.generalelements.FieldDeclaration;
import astgenerator.generalelements.GeneralThing;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import tastgenerator.expressions.TypedExpression;

public class TypedFieldDeclaration extends TypedGeneralThing
{
    private AccessModifier accessModifier;
    private Modifier modifier;
    private ObjectType variableType;
    private String name;
    private TypedExpression typedExpression;

    public TypedFieldDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType variableType, String name)
    {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.variableType = variableType;
        this.name = name;
        this.objectType = variableType;
    }

    public TypedFieldDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType variableType, String name, TypedExpression typedExpression)
    {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.variableType = variableType;
        this.name = name;
        this.objectType = variableType;
        this.typedExpression = typedExpression;
    }

    public String getName()
    {
        return name;
    }

    public ObjectType getVariableType() { return variableType; }

    public AccessModifier getAccessModifier()
    {
        return accessModifier;
    }

    public Modifier getModifier()
    {
        return modifier;
    }

    public TypedExpression getTypedExpression() {
        return typedExpression;
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

        TypedFieldDeclaration that = (TypedFieldDeclaration) o;

        if (accessModifier != that.accessModifier)
        {
            return false;
        }
        if (modifier != that.modifier)
        {
            return false;
        }
        if (variableType != null ? !variableType.equals(that.variableType) : that.variableType != null)
        {
            return false;
        }
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (accessModifier != null ? accessModifier.hashCode() : 0);
        result = 31 * result + (modifier != null ? modifier.hashCode() : 0);
        result = 31 * result + (variableType != null ? variableType.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
