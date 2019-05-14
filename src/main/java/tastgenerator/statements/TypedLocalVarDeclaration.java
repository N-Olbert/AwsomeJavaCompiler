package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

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
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
