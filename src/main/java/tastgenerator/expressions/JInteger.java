package tastgenerator.expressions;

import tastgenerator.generalelements.ObjectType;

public class JInteger extends Expression
{
    private int jint;

    public JInteger(String jint)
    {
        this.jint = Integer.parseInt(jint);
        this.objectType = ObjectType.IntType;
    }
}