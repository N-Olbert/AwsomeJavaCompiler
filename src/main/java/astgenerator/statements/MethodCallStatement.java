package astgenerator.statements;

import astgenerator.expressions.Expression;
import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.List;
import java.util.Objects;

public class MethodCallStatement extends Statement
{
    private Expression object;
    private String name;
    private List<Expression> parameters;

    public MethodCallStatement(Expression object, String name, List<Expression> parameters)
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
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodCallStatement that = (MethodCallStatement) o;
        return Objects.equals(object, that.object) &&
                Objects.equals(name, that.name) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object, name, parameters);
    }
}
