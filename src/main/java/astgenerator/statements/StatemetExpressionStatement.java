package astgenerator.statements;

import astgenerator.statementexpressions.StatementExpression;

public class StatemetExpressionStatement extends Statement
{
    private StatementExpression statementExpression;

    public StatemetExpressionStatement(StatementExpression statementExpression)
    {
        this.statementExpression = statementExpression;
    }

    public StatementExpression getStatementExpression()
    {
        return statementExpression;
    }
}
