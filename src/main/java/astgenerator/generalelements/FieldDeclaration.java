package astgenerator.generalelements;

import astgenerator.expressions.Expression;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

import java.util.Objects;

public class FieldDeclaration extends GeneralThing
{
    private AccessModifier accessModifier;
    private Modifier modifier;
    private ObjectType variableType;
    private String name;
    private Expression expression;

    public FieldDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType variableType, String name)
    {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.variableType = variableType;
        this.name = name;
        this.expression = null;
    }

    public FieldDeclaration(ObjectType variableType, String name)
    {
        this.accessModifier = AccessModifier.PACKAGE_PRIVATE;
        this.modifier = Modifier.NONE;
        this.variableType = variableType;
        this.name = name;
        this.expression = null;
    }

    public FieldDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType variableType, String name, Expression expression)
    {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.variableType = variableType;
        this.name = name;
        this.expression = expression;
    }

    public FieldDeclaration(ObjectType variableType, String name, Expression expression)
    {
        this.accessModifier = AccessModifier.PACKAGE_PRIVATE;
        this.modifier = Modifier.NONE;
        this.variableType = variableType;
        this.name = name;
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

    public Expression getExpression() {
        return expression;
    }

    @Override
    public TypedGeneralThing toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldDeclaration that = (FieldDeclaration) o;
        return accessModifier == that.accessModifier &&
                modifier == that.modifier &&
                Objects.equals(variableType, that.variableType) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessModifier, modifier, variableType, name);
    }
}
