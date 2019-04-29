package tastgenerator.expressions;


import common.ObjectType;

public class TypedBoolean extends TypedExpression
{
    private boolean jBool;

    public TypedBoolean(String jBool){
        this.jBool = Boolean.parseBoolean(jBool);
        this.objectType = ObjectType.BoolType;
    }

    public boolean getJBool(){
        return jBool;
    }
}
