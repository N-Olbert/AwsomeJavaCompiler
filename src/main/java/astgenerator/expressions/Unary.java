package astgenerator.expressions;
import common.Operators;
import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

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

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
