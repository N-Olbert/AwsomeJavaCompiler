package astgenerator.statements;

import astgenerator.expressions.Expression;
import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.List;

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
}
