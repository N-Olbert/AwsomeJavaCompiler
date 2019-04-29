package astgenerator.expressions;
import common.Operators;

public class Unary extends Expression
{
    private Expression expression;
    private Operators operator;
    public Unary(Expression expression, Operators operator)
    {
        this.expression = expression;
        this.operator = operator;
    }

    public Expression getExpression()
    {
        return expression;
    }

    public Operators getOperator()
    {
        return operator;
    }
}
