package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public class This extends Expression
{

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof This;
    }
}
