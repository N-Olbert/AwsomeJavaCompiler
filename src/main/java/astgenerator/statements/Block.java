package astgenerator.statements;

import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Block extends Statement
{
    private List<Statement> blockedStatements;

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
}
