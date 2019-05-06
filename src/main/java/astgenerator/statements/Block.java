package astgenerator.statements;

import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.List;

public class Block extends Statement
{
    private List<Statement> blockedStatements;

    public Block(List<Statement> blockedStatements)
    {
        this.blockedStatements = blockedStatements;
    }

    public List<Statement> getBlockedStatements()
    {
        return blockedStatements;
    }

    @Override
    public TypedStatement toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
