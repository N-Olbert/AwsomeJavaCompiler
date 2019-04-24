package tastgenerator.expressions;

import tastgenerator.generalelements.ObjectType;

public class JCharacter extends Expression
{
    private char jChar;

    public JCharacter(String jChar){
        this.jChar = jChar.charAt(0);
        this.objectType = ObjectType.CharType;
    }

    public char getJChar(){
        return jChar;
    }
}
