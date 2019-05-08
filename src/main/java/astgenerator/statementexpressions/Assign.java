package astgenerator.statementexpressions;

import astgenerator.expressions.Expression;
import tastgenerator.TypeChecker;
import tastgenerator.statementexpressions.TypedStatementExpression;

public class Assign extends StatementExpression
{
    private Expression expression1;
    private Expression expression2;

    public Assign(Expression expression1, Expression expression2) {
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
    public TypedStatementExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
