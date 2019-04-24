package tastgenerator.statements;

import tastgenerator.expressions.Expression;

public class IfElse extends Statement
{
    private Expression condition;
    private Statement then;
    private Statement otherwise;

    public IfElse(Expression condition, Statement then, Statement otherwise)
    {
        this.condition = condition;
        this.then = then;
        this.otherwise = otherwise;
    }

    public Expression getCondition()
    {
        return condition;
    }

    public Statement getThen()
    {
        return then;
    }

    public Statement getOtherwise()
    {
        return otherwise;
    }
}
