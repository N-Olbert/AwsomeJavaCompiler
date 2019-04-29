package tastgenerator.statements;

import tastgenerator.expressions.TypedExpression;

public class TypedReturn extends TypedStatement
{
    private TypedExpression exp;
    public TypedReturn(TypedExpression exp)
    {
        this.exp = exp;
    }

    public TypedExpression getExp()
    {
        return exp;
    }
}
