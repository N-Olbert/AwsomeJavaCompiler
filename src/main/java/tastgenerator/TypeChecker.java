package tastgenerator;

import astgenerator.expressions.Binary;
import astgenerator.statements.Return;
import astgenerator.statements.While;
import tastgenerator.expressions.TypedBinary;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedWhile;

public interface TypeChecker
{
    TypedWhile TypeCheckWhile(While toCheck);
    TypedReturn TypeCheckReturn(Return toCheck);
    TypedBinary TypeCheckBinary(Binary toCheck);
}
