package tastgenerator.statements;

import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public TypedBlock(List<TypedStatement> blockedStatements, ObjectType objectType)
    {
        this.blockedStatements = blockedStatements;
        setObjectType(objectType);
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {
        Generator.generate(this, visitor, localVar);
    }
}
