package tastgenerator.statements;

import tastgenerator.expressions.TypedExpression;

public class TypedWhile extends TypedStatement
{
    private TypedExpression exp;
    private TypedStatement stmt;

    public TypedWhile(TypedExpression exp, TypedStatement stmt)
    {
        this.exp = exp;
        this.stmt = stmt;
    }

    public TypedExpression getExp()
    {
        return exp;
    }

    public TypedStatement getStmt()
    {
        return stmt;
    }
}
