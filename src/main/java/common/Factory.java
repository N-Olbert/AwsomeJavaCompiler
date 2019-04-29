package common;

public interface Factory
{
    ASTGenerator getASTGenerator();
    TypedASTGenerator getTypedAstGenerator();
    BytecodeGenerator getBytecodeGenerator();
}
