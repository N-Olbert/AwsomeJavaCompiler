package tastgenerator.statements;

import tastgenerator.generalelements.ObjectType;

public class LocalVarDeclaration extends Statement
{
    private ObjectType variableType;
    private String name;

    public LocalVarDeclaration(ObjectType variableType, String name)
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
