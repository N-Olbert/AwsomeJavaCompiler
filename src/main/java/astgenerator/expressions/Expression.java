package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public abstract class Expression
{
    public abstract TypedExpression toTyped(TypeChecker converter);
    /*{
        if(this instanceof Binary)
        {
            return converter.typeCheck((Binary) this);
        }

        throw new IllegalStateException("NOPE");
    }*/
}
