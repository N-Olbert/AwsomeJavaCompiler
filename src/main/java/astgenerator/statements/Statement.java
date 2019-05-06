package astgenerator.statements;

import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.statements.TypedStatement;

public abstract class Statement
{
    public abstract TypedStatement toTyped(TypeChecker converter);
}
