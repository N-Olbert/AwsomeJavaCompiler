package astgenerator.statements;

import astgenerator.expressions.Expression;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

public class Return extends Statement
{
    private Expression exp;
    public Return(Expression exp)
    {
        this.exp = exp;
    }

    public Expression getExp()
    {
        return exp;
    }

    @Override
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}