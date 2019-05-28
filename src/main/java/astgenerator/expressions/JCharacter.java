package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JCharacter that = (JCharacter) o;
        return jChar == that.jChar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jChar);
    }
}
