package tastgenerator.expressions;

import astgenerator.expressions.Expression;
import astgenerator.expressions.This;
import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedProgram;

/**
 * @author NO
 */
public class TypedThisWrapper extends TypedExpression
{
    private TypedThis theThis;
    private TypedExpression thisRelatedExpression;

    public TypedThisWrapper(TypedThis theThis, TypedExpression thisRelatedExpression)
    {
        this.theThis = theThis;
        this.thisRelatedExpression = thisRelatedExpression;
    }

    public TypedExpression getThisRelatedExpression()
    {
        return thisRelatedExpression;
    }

    public TypedThis getTheThis()
    {
        return theThis;
    }
}
