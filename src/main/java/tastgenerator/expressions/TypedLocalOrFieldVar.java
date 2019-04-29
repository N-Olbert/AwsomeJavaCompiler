package tastgenerator.expressions;

import common.ObjectType;

public class TypedLocalOrFieldVar extends TypedExpression
{
    private String name;
    public TypedLocalOrFieldVar(ObjectType objectType, String name){
        this.objectType = objectType;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

}
