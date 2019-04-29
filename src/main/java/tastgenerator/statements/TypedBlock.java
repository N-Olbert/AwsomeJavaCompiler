package tastgenerator.statements;

import java.util.List;

public class TypedBlock extends TypedStatement
{
    private List<TypedStatement> blockedStatements;

    public TypedBlock(List<TypedStatement> blockedStatements)
    {
        this.blockedStatements = blockedStatements;
    }

    public List<TypedStatement> getBlockedStatements()
    {
        return blockedStatements;
    }
}
