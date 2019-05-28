package astgenerator.expressions;

import tastgenerator.TypeChecker;
import tastgenerator.expressions.TypedExpression;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalOrFieldVar that = (LocalOrFieldVar) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
