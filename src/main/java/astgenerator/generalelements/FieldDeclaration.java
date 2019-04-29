package astgenerator.generalelements;

import common.AccessModifier;
import common.Modifier;
import common.ObjectType;

public class FieldDeclaration extends GeneralThing
{
    private AccessModifier accessModifier;
    private Modifier modifier;
    private ObjectType variableType;
    private String name;

    public FieldDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType variableType, String name)
    {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.variableType = variableType;
        this.name = name;
    }

    public FieldDeclaration(ObjectType variableType, String name)
    {
        this.accessModifier = AccessModifier.PACKAGE_PRIVATE;
        this.modifier = Modifier.NONE;
        this.variableType = variableType;
        this.name = name;
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
