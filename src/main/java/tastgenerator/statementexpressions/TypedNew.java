package tastgenerator.statementexpressions;

import common.ObjectType;
import tastgenerator.expressions.TypedExpression;

import java.util.List;

public class TypedNew extends TypedStatementExpression
{
    ObjectType newType;
    List<TypedExpression> parameters;

    public TypedNew(ObjectType newType, List<TypedExpression> expressions)
    {
        this.newType = newType;
        this.parameters = expressions;
    }

    public ObjectType getNewType()
    {
        return newType;
    }

    public List<TypedExpression> getParameters()
    {
        return parameters;
    }
}
