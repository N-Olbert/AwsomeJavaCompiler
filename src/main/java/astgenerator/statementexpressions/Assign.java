package astgenerator.statementexpressions;

import astgenerator.expressions.Expression;
import tastgenerator.TypeChecker;
import tastgenerator.statementexpressions.TypedStatementExpression;

public class Assign extends StatementExpression
{
    private String name;
    private Expression expression;

    public Assign(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    public String getName() {
        return this.name;
    }

    public Expression getExpression() {
        return this.expression;
    }

    @Override
    public TypedStatementExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
