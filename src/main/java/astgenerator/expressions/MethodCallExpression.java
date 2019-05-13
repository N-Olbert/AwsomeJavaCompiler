package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.List;

public class MethodCallExpression extends Expression
{
    private Expression object;
    private String name;
    private List<Expression> parameters;

    public MethodCallExpression(Expression object, String name, List<Expression> parameters)
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

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
