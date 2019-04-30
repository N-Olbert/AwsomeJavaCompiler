package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public class JCharacter extends Expression
{
    private char jChar;

    public JCharacter(String jChar){
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
