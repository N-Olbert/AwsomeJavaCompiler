package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JBoolean jBoolean = (JBoolean) o;
        return jBool == jBoolean.jBool;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jBool);
    }
}
