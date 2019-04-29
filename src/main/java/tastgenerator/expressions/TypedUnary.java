package tastgenerator.expressions;

import common.Operators;

public class TypedUnary extends TypedExpression
{
    private TypedExpression expression;
    private Operators operator;
    public TypedUnary(TypedExpression expression, Operators operator)
    {
        this.expression = expression;
        this.operator = operator;
    }

    public TypedExpression getExpression()
    {
        return expression;
    }

    public Operators getOperator()
    {
        return operator;
    }
}
