package astgenerator.expressions;

public class JCharacter extends Expression
{
    private char jChar;

    public JCharacter(String jChar){
        this.jChar = jChar.charAt(0);
    }

    public char getJChar(){
        return jChar;
    }
}
