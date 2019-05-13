package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

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
}
