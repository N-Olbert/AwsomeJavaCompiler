package tastgenerator.statements;

import tastgenerator.statementexpressions.TypedStatementExpression;

public class TypedStatemetExpressionStatement extends TypedStatement
{
    private TypedStatementExpression statementExpression;

    public TypedStatemetExpressionStatement(TypedStatementExpression statementExpression)
    {
        this.statementExpression = statementExpression;
    }

    public TypedStatementExpression getStatementExpression()
    {
        return statementExpression;
    }
}
