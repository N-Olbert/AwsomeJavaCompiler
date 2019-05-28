package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypedBlock extends TypedStatement
{
    private List<TypedStatement> blockedStatements;

    public TypedBlock(List<TypedStatement> blockedStatements, ObjectType objectType)
    {
        this.blockedStatements = blockedStatements;
        this.objectType = objectType;
    }
    public TypedBlock(ObjectType objectType, TypedStatement... blockedStatements)
    {
        this.blockedStatements = Arrays.asList(blockedStatements);
        this.objectType = objectType;
    }


    public List<TypedStatement> getBlockedStatements()
    {
        return blockedStatements;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        if (!super.equals(o))
        {
            return false;
        }

        TypedBlock that = (TypedBlock) o;

        return blockedStatements != null ? blockedStatements.equals(that.blockedStatements) : that.blockedStatements == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (blockedStatements != null ? blockedStatements.hashCode() : 0);
        return result;
    }
}
