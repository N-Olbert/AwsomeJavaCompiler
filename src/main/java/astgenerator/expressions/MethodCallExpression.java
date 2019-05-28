package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodCallExpression that = (MethodCallExpression) o;
        return Objects.equals(object, that.object) &&
                Objects.equals(name, that.name) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object, name, parameters);
    }
}
