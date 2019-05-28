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
    private TypedExpression expression;

    public TypedFieldDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType variableType, String name)
    {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.variableType = variableType;
        this.name = name;
        this.objectType = variableType;
        this.expression = null;
    }

    public TypedFieldDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType variableType, String name, TypedExpression expression)
    {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.variableType = variableType;
        this.name = name;
        this.objectType = variableType;
        this.expression = expression;
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

    public TypedExpression getExpression() {
        return expression;
    }
}
