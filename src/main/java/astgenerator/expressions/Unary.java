package astgenerator.expressions;
import common.Operators;
import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unary unary = (Unary) o;
        return Objects.equals(expression, unary.expression) &&
                operator == unary.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, operator);
    }
}
