package tastgenerator.statements;

import bytecodegenerator.GenerateByteCodeStatement;
import common.ObjectType;

public abstract class TypedStatement implements GenerateByteCodeStatement
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
