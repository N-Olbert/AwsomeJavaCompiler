package common;

import tastgenerator.generalelements.Program;

import java.io.InputStream;

public interface ASTGenerator
{
    Program getAST(InputStream stream);
}
