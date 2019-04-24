package tastgenerator.expressions;

import tastgenerator.generalelements.ObjectType;

public class JBoolean extends Expression
{
    private boolean jBool;

    public JBoolean(String jBool){
        this.jBool = Boolean.parseBoolean(jBool);
        this.objectType = ObjectType.BoolType;
    }

    public boolean getJBool(){
        return jBool;
    }
}
