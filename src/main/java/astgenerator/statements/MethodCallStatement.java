package astgenerator.statements;

import astgenerator.expressions.Expression;
import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.List;

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
}
