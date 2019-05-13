package tastgenerator.generalelements;

import astgenerator.generalelements.FieldDeclaration;
import astgenerator.generalelements.GeneralThing;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;

public class TypedFieldDeclaration extends TypedGeneralThing
{
    private AccessModifier accessModifier;
    private Modifier modifier;
    private ObjectType variableType;
    private String name;

    public TypedFieldDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType variableType, String name)
    {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.variableType = variableType;
        this.name = name;
    }
    public TypedFieldDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType variableType, String name, ObjectType objectType)
    {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.variableType = variableType;
        this.name = name;
        setObjectType(objectType);
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
}
