package common;

import astgenerator.generalelements.UntypedProgram;

import java.io.InputStream;

public interface ASTGenerator
{
    UntypedProgram getAST(InputStream stream);
}
