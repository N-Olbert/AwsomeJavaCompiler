package tastgenerator.expressions;

import tastgenerator.generalelements.Operators;

public class Unary
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
