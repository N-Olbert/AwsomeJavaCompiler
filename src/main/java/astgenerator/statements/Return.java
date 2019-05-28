package astgenerator.statements;

import astgenerator.expressions.Expression;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.Objects;

public class Return extends Statement
{
    private Expression exp;
    public Return(Expression exp)
    {
        this.exp = exp;
    }

    public Return () {

    }

    public Expression getExp()
    {
        return exp;
    }

    @Override
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Return aReturn = (Return) o;
        return Objects.equals(exp, aReturn.exp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exp);
    }
}
