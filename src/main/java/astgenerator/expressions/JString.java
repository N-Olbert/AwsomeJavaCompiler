package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

public class JString extends Expression
{
    private String jString;

    public JString(String jString){
        this.jString = jString;
    }

    public String getJString(){
        return jString;
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
