package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public abstract class Expression
{
    public TypedExpression toTyped(TypeChecker converter)
    {
        if(this instanceof Binary)
        {
            return converter.TypeCheckBinary((Binary) this);
        }

        throw new IllegalStateException("NOPE");
    }
}
