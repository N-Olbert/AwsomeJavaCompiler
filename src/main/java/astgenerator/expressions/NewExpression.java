package astgenerator.expressions;

import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.List;

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
}
