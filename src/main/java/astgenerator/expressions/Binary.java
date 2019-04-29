package astgenerator.expressions;

import common.Operators;

public class Binary extends Expression
{
    private Expression expression;
    private Expression expression2;
    private Operators operator;
    public Binary(Expression expression, Expression expression2, Operators operator)
    {
        this.expression = expression;
        this.expression2 = expression2;
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

    public Expression getExpression2()
    {
        return expression2;
    }
}
