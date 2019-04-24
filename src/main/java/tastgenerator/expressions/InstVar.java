package tastgenerator.expressions;

import tastgenerator.generalelements.ObjectType;

public class InstVar extends Expression
{
    private String name;
    private Expression expression;
    private ObjectType objectType;
    public InstVar(Expression expression, String name){
        this.expression = expression;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Expression getExpression()
    {
        return expression;
    }

    public ObjectType getObjectType()
    {
        return objectType;
    }

    public void setObjectType(ObjectType objectType)
    {
        this.objectType = objectType;
    }
}
