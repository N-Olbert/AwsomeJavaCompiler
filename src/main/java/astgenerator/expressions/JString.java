package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JString jString1 = (JString) o;
        return Objects.equals(jString, jString1.jString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jString);
    }
}
