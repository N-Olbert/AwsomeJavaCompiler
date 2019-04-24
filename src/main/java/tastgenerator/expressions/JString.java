package tastgenerator.expressions;

import tastgenerator.generalelements.ObjectType;

public class JString extends Expression{
    private String jString;

    public JString(String jString){
        this.jString = jString;
        this.objectType = ObjectType.StringType;
    }

    public String getJString(){
        return jString;
    }
}
