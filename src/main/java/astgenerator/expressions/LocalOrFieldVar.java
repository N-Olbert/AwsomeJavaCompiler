package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public class LocalOrFieldVar extends Expression
{
    private String name;
    public LocalOrFieldVar(String name){
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
