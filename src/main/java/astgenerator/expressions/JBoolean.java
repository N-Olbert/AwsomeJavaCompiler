package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public class JBoolean extends Expression
{
    private boolean jBool;

    public JBoolean(String jBool){
        this.jBool = Boolean.parseBoolean(jBool);
    }

    public boolean getJBool(){
        return jBool;
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
