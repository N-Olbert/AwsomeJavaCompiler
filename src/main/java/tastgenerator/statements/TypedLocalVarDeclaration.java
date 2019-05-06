package tastgenerator.statements;

import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedLocalVarDeclaration extends TypedStatement
{
    private ObjectType variableType;
    private String name;

    public TypedLocalVarDeclaration(ObjectType variableType, String name)
    {
        this.variableType = variableType;
        this.name = name;
    }

    public ObjectType getVariableType()
    {
        return variableType;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
