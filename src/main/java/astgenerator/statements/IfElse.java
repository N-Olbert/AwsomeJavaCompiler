package astgenerator.statements;

import astgenerator.expressions.Expression;

public class IfElse extends Statement
{
    private Expression condition;
    private Block then;
    private Block otherwise;

    public IfElse(Expression condition, Block then, Block otherwise)
    {
        this.condition = condition;
        this.then = then;
        this.otherwise = otherwise;
    }

    public Expression getCondition()
    {
        return condition;
    }

    public Block getThen()
    {
        return then;
    }

    public Block getOtherwise()
    {
        return otherwise;
    }
}
