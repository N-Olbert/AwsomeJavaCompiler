package tastgenerator.expressions;

import tastgenerator.statementexpressions.StatementExpression;

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
}
