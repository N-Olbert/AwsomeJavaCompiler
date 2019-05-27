package astgenerator.statements;

import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.Objects;

public class LocalVarDeclaration extends Statement
{
    private ObjectType variableType;
    private String name;

    public LocalVarDeclaration(ObjectType variableType, String name)
    {
        this.variableType = variableType;
        this.name = name;
    }

    public ObjectType getVariableType()
    {
        return variableType;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalVarDeclaration that = (LocalVarDeclaration) o;
        return Objects.equals(variableType, that.variableType) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableType, name);
    }
}
