package astgenerator.statements;

import astgenerator.expressions.Expression;
import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.List;
import java.util.Objects;

public class NewStatement extends Statement
{
    private ObjectType newType;
    private List<Expression> parameters;

    public NewStatement(ObjectType newType, List<Expression> expressions)
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
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewStatement that = (NewStatement) o;
        return Objects.equals(newType, that.newType) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newType, parameters);
    }
}
