package astgenerator.statements;

import astgenerator.expressions.Expression;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.Objects;

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

    @Override
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        While aWhile = (While) o;
        return Objects.equals(exp, aWhile.exp) &&
                Objects.equals(stmt, aWhile.stmt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exp, stmt);
    }
}
