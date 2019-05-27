package astgenerator.statements;

import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Block extends Statement
{
    private List<Statement> blockedStatements;
    public Block(ArrayList<Statement> statements)
    {
        var newList = new ArrayList<Statement>();
        if(statements != null)
        {
            newList = statements;
        }

        this.blockedStatements = newList;
    }
    public Block(Statement... blockedStatements)
    {
        var newList = new ArrayList<Statement>();
        if(blockedStatements != null)
        {
            Collections.addAll(newList, blockedStatements);
        }

        this.blockedStatements = newList;
    }

    public List<Statement> getBlockedStatements()
    {
        return blockedStatements;
    }

    @Override
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(blockedStatements, block.blockedStatements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockedStatements);
    }
}
