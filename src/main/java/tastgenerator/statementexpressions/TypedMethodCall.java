package tastgenerator.statementexpressions;

import tastgenerator.expressions.TypedExpression;

import java.util.List;

public class TypedMethodCall extends TypedStatementExpression
{
    private TypedExpression object;
    private String name;
    private List<TypedExpression> parameters;

    public TypedMethodCall(TypedExpression object, String name, List<TypedExpression> parameters)
    {
        this.object = object;
        this.name = name;
        this.parameters = parameters;
    }

    public TypedExpression getObject()
    {
        return object;
    }

    public String getName()
    {
        return name;
    }

    public List<TypedExpression> getParameters()
    {
        return parameters;
    }
}
