package astgenerator.statements;

import astgenerator.expressions.Expression;
import tastgenerator.statements.TypedStatement;

public class While extends Statement
{
    private Expression exp;
    private Block stmt;

    public While(Expression exp, Block stmt)
    {
        this.exp = exp;
        this.stmt = stmt;
    }

    public Expression getExp()
    {
        return exp;
    }

    public Block getStmt()
    {
        return stmt;
    }
}
