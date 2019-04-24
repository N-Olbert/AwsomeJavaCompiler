package tastgenerator.statementexpressions;

import tastgenerator.expressions.Expression;

import java.util.List;

public class MethodCall
{
    private Expression object;
    private String name;
    private List<Expression> parameters;

    public MethodCall(Expression object, String name, List<Expression> parameters)
    {
        this.object = object;
        this.name = name;
        this.parameters = parameters;
    }

    public Expression getObject()
    {
        return object;
    }

    public String getName()
    {
        return name;
    }

    public List<Expression> getParameters()
    {
        return parameters;
    }
}
