package tastgenerator.expressions;

import common.ObjectType;
import common.Operators;

public class TypedUnary extends TypedExpression
{
    private TypedExpression expression;
    private Operators operator;
    public TypedUnary(TypedExpression expression, Operators operator, ObjectType objectType)
    {
        this.expression = expression;
        this.operator = operator;
        this.objectType = objectType;
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
