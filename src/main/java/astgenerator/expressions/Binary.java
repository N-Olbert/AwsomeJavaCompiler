package astgenerator.expressions;

import common.Operators;
import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.Objects;

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

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Binary binary = (Binary) o;
        return Objects.equals(expression, binary.expression) &&
                Objects.equals(expression2, binary.expression2) &&
                operator == binary.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, expression2, operator);
    }
}
