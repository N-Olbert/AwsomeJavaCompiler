package tastgenerator.expressions;

import tastgenerator.statementexpressions.TypedStatementExpression;

public class TypedStatementExpressionExpression extends TypedExpression
{
    private TypedStatementExpression stmtExpr;

    public TypedStatementExpressionExpression(TypedStatementExpression stmtExpr)
    {
        this.stmtExpr = stmtExpr;
    }

    public TypedStatementExpression getStmtExpr()
    {
        return stmtExpr;
    }
}
