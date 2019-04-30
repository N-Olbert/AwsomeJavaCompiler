package astgenerator.statementexpressions;

import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.statementexpressions.TypedStatementExpression;

public abstract class StatementExpression
{
    public abstract TypedStatementExpression toTyped(TypeChecker converter);
}
