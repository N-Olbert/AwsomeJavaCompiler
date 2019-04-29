package tastgenerator.expressions;
public class TypedInstVar extends TypedExpression
{
    private String name;
    private TypedExpression expression;
    public TypedInstVar(TypedExpression expression, String name){
        this.expression = expression;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public TypedExpression getExpression()
    {
        return expression;
    }
}
