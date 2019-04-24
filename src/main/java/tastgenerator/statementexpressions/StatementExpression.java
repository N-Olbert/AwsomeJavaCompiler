package tastgenerator.statementexpressions;

import tastgenerator.generalelements.ObjectType;

public abstract class StatementExpression
{
    protected ObjectType objectType;

    public ObjectType getObjectType()
    {
        return objectType;
    }

    public void setObjectType(ObjectType objectType)
    {
        this.objectType = objectType;
    }
}
