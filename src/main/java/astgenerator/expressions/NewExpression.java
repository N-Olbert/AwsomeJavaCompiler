package astgenerator.expressions;

import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.List;
import java.util.Objects;

public class NewExpression extends Expression
{
    private ObjectType newType;
    private List<Expression> parameters;

    public NewExpression(ObjectType newType, List<Expression> expressions)
    {
        this.newType = newType;
        this.parameters = expressions;
    }

    public ObjectType getNewType()
    {
        return newType;
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
        NewExpression that = (NewExpression) o;
        return Objects.equals(newType, that.newType) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newType, parameters);
    }
}
