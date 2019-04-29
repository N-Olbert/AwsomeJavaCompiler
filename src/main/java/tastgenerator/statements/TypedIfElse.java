package tastgenerator.statements;

import tastgenerator.expressions.TypedExpression;

public class TypedIfElse extends TypedStatement
{
    private TypedExpression condition;
    private TypedBlock then;
    private TypedBlock otherwise;

    public TypedIfElse(TypedExpression condition, TypedBlock then, TypedBlock otherwise)
    {
        this.condition = condition;
        this.then = then;
        this.otherwise = otherwise;
    }

    public TypedExpression getCondition()
    {
        return condition;
    }

    public TypedBlock getThen()
    {
        return then;
    }

    public TypedBlock getOtherwise()
    {
        return otherwise;
    }
}
