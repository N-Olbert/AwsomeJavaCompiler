package tastgenerator.statementexpressions;

import common.ObjectType;

public abstract class TypedStatementExpression
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
