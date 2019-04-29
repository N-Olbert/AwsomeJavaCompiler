package common;

import astgenerator.generalelements.UntypedProgram;
import tastgenerator.generalelements.TypedProgram;

public interface TypedASTGenerator
{
    TypedProgram getTypedProgram(UntypedProgram ast);
}
