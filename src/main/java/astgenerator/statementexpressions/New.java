package astgenerator.statementexpressions;

import astgenerator.expressions.Expression;
import common.ObjectType;

import java.util.List;

public class New extends StatementExpression
{
    ObjectType newType;
    List<Expression> parameters;

    public New(ObjectType newType, List<Expression> expressions)
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
}
