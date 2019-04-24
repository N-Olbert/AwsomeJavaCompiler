package tastgenerator.statementexpressions;

import tastgenerator.expressions.Expression;

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
}
