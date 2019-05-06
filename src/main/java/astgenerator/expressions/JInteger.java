package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public class JInteger extends Expression
{
    private int jint;

    public JInteger(String jint)
    {
        this.jint = Integer.parseInt(jint);
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}