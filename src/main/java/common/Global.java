package common;

public class Global implements Factory
{
    private Global()
    {

    }

    public static Factory getFactory()
    {
        return new Global();
    }

    public ASTGenerator getASTGenerator()
    {
        //TODO: Daniel
        return null;
    }

    public TypedASTGenerator getTypedAstGenerator()
    {
        return new TASTGenerator();
    }

    public BytecodeGenerator getBytecodeGenerator()
    {
        //TODO: Nico
        return null;
    }
}
