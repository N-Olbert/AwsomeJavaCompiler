package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

/**
 * @author NO
 */
public class ThisWrapper extends Expression
{
    private This theThis;
    private Expression thisRelatedExpression;

    public ThisWrapper(This theThis, Expression thisRelatedExpression)
    {
        this.theThis = theThis;
        this.thisRelatedExpression = thisRelatedExpression;
    }

    public Expression getThisRelatedExpression()
    {
        return thisRelatedExpression;
    }

    public This getTheThis()
    {
        return theThis;
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter)
    {
        return null;
    }
}
