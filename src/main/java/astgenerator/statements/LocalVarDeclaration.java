package astgenerator.statements;

import astgenerator.expressions.Expression;
import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

public class LocalVarDeclaration extends Statement
{
    private ObjectType variableType;
    private String name;
    private Expression expression;

    public LocalVarDeclaration(ObjectType variableType, String name)
    {
        this.variableType = variableType;
        this.name = name;
        this.expression = null;
    }

    public LocalVarDeclaration(ObjectType variableType, String name, Expression expression)
    {
        this.variableType = variableType;
        this.name = name;
        this.expression = expression;
    }

    public ObjectType getVariableType()
    {
        return variableType;
    }

    public String getName()
    {
        return name;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
