package tastgenerator;

import astgenerator.expressions.Binary;
import astgenerator.statements.Return;
import astgenerator.statements.While;
import tastgenerator.expressions.TypedBinary;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedWhile;

public class TypeCheckerInstance implements TypeChecker
{

    @Override
    public TypedWhile TypeCheckWhile(While toCheck)
    {
        return null;
    }

    @Override
    public TypedReturn TypeCheckReturn(Return toCheck)
    {
        return null;
    }

    @Override
    public TypedBinary TypeCheckBinary(Binary toCheck)
    {
        return null;
    }
}
