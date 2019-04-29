package tastgenerator.expressions;


import common.ObjectType;

public class TypedChar extends TypedExpression
{
    private char jChar;

    public TypedChar(String jChar){
        this.jChar = jChar.charAt(0);
        this.objectType = ObjectType.CharType;
    }

    public char getJChar(){
        return jChar;
    }
}
