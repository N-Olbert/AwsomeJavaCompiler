package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.Objects;

public class InstVar extends Expression
{
    private String name;
    private Expression expression;
    public InstVar(Expression expression, String name){
        this.expression = expression;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Expression getExpression()
    {
        return expression;
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstVar instVar = (InstVar) o;
        return Objects.equals(name, instVar.name) &&
                Objects.equals(expression, instVar.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expression);
    }
}
