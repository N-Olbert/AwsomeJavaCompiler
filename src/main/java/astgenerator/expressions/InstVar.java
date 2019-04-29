package astgenerator.expressions;

public class InstVar extends Expression
{
    private String name;
    private Expression expression;
    public InstVar(Expression expression, String name){
        this.expression = expression;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Expression getExpression()
    {
        return expression;
    }
}
