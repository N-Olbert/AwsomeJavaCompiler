package tastgenerator.statements;

import common.ObjectType;

public class TypedLocalVarDeclaration extends TypedStatement
{
    private ObjectType variableType;
    private String name;

    public TypedLocalVarDeclaration(ObjectType variableType, String name)
    {
        this.variableType = variableType;
        this.name = name;
    }

    public ObjectType getVariableType()
    {
        return variableType;
    }

    public String getName()
    {
        return name;
    }
}
