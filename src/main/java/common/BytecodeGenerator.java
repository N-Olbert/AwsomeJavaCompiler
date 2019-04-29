package common;

import tastgenerator.generalelements.TypedProgram;

import java.io.OutputStream;

public interface BytecodeGenerator
{
    OutputStream getByteCode(TypedProgram typedAst);
}
