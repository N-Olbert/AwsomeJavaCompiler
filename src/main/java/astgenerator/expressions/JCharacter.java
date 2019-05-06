package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public class JCharacter extends Expression
{
    private char jChar;

    public JCharacter(String jChar){
        if(jChar.length() > 1)
        {
            throw new IllegalArgumentException("Char can only have length of 1");
        }

        this.jChar = jChar.charAt(0);
    }

    public char getJChar(){
        return jChar;
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
