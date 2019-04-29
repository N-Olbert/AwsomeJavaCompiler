package astgenerator.expressions;

public class JInteger extends Expression
{
    private int jint;

    public JInteger(String jint)
    {
        this.jint = Integer.parseInt(jint);
    }
}