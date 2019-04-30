package astgenerator.statements;

import astgenerator.statementexpressions.StatementExpression;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

public class StatementExpressionStatement extends Statement
{
    private StatementExpression statementExpression;

    public StatementExpressionStatement(StatementExpression statementExpression)
    {
        this.statementExpression = statementExpression;
    }

    public StatementExpression getStatementExpression()
    {
        return statementExpression;
    }

    @Override
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
