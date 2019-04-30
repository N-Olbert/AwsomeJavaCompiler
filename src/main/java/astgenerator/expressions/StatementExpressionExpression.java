package astgenerator.expressions;

import astgenerator.statementexpressions.StatementExpression;
import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public class StatementExpressionExpression extends Expression
{
    private StatementExpression stmtExpr;

    public StatementExpressionExpression(StatementExpression stmtExpr)
    {
        this.stmtExpr = stmtExpr;
    }

    public StatementExpression getStmtExpr()
    {
        return stmtExpr;
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
