package tastgenerator.generalelements;

public class FieldDeclaration
{
    private ObjectType objectType;
    private ObjectType variableType;
    private String name;

    public FieldDeclaration(ObjectType variableType, String name)
    {
        this.variableType = variableType;
        this.name = name;
    }

    public ObjectType getObjectType()
    {
        return objectType;
    }

    public void setObjectType(ObjectType objectType)
    {
        this.objectType = objectType;
    }

    public String getName()
    {
        return name;
    }

    public ObjectType getVariableType() { return variableType; }
}
