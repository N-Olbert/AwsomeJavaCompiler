package common;

import tastgenerator.generalelements.Program;

public interface TypedASTGenerator
{
    Program getTypedProgram(Program ast);
}
