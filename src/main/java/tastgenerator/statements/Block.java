package tastgenerator.statements;

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
}
