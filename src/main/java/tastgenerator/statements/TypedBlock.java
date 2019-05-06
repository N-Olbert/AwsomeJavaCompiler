package tastgenerator.statements;

import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;

import java.util.List;

public class TypedBlock extends TypedStatement
{
    private List<TypedStatement> blockedStatements;

    public TypedBlock(List<TypedStatement> blockedStatements)
    {
        this.blockedStatements = blockedStatements;
    }

    public List<TypedStatement> getBlockedStatements()
    {
        return blockedStatements;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
