package tastgenerator.statements;

import tastgenerator.expressions.Expression;

public class While extends Statement
{
    private Expression exp;
    private Statement stmt;

    public While(Expression exp, Statement stmt)
    {
        this.exp = exp;
        this.stmt = stmt;
    }

    public Expression getExp()
    {
        return exp;
    }

    public Statement getStmt()
    {
        return stmt;
    }
}
