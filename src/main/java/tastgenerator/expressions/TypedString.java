package tastgenerator.expressions;

import common.ObjectType;

public class TypedString extends TypedExpression{
    private String jString;

    public TypedString(String jString){
        this.jString = jString;
        this.objectType = ObjectType.StringType;
    }

    public String getJString(){
        return jString;
    }
}
