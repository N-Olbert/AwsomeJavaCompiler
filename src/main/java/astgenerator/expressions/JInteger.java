package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.Objects;

public class JInteger extends Expression
{
    private int jint;

    public JInteger(String jint)
    {
        this.jint = Integer.parseInt(jint);
    }

    public int getJint() {
        return jint;
    }

    @Override
    public TypedExpression toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JInteger jInteger = (JInteger) o;
        return jint == jInteger.jint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jint);
    }
}