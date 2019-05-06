package common;

import astgenerator.generalelements.UntypedProgram;
import tastgenerator.TypeCheckerInstance;
import tastgenerator.generalelements.TypedProgram;

/**
 * @author NO
 */
public class TASTGenerator implements TypedASTGenerator
{
    @Override
    public TypedProgram getTypedProgram(UntypedProgram ast)
    {
        var converter = new TypeCheckerInstance(ast);
        return converter.typeCheck(ast);
    }
}
