package astgenerator.statements;

import astgenerator.expressions.Expression;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.ArrayList;
import java.util.Objects;

public class IfElse extends Statement {
    private Expression condition;
    private Block then;
    private Block otherwise;

    public IfElse(Expression condition, Block then, Block otherwise) {
        this.condition = condition;
        this.then = then;
        this.otherwise = otherwise;
    }

    public IfElse(Expression condition, Block then) {
        this.condition = condition;
        this.then = then;
        this.otherwise = new Block(new ArrayList<>());
    }

    public Expression getCondition() {
        return condition;
    }

    public Block getThen() {
        return then;
    }

    public Block getOtherwise() {
        return otherwise;
    }

    @Override
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IfElse ifElse = (IfElse) o;
        return Objects.equals(condition, ifElse.condition) &&
                Objects.equals(then, ifElse.then) &&
                Objects.equals(otherwise, ifElse.otherwise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, then, otherwise);
    }
}
