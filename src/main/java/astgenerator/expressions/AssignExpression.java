package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.Objects;

public class AssignExpression extends Expression
{
    private Expression expression1;
    private Expression expression2;

    public AssignExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public Expression getExpression1() {
        return this.expression1;
    }

    public Expression getExpression2() {
        return this.expression2;
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignExpression that = (AssignExpression) o;
        return Objects.equals(expression1, that.expression1) &&
                Objects.equals(expression2, that.expression2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression1, expression2);
    }
}
