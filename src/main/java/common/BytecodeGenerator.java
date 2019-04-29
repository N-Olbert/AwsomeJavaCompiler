package common;

import tastgenerator.generalelements.Program;

import java.io.OutputStream;

public interface BytecodeGenerator
{
    OutputStream getByteCode(Program typedAst);
}
