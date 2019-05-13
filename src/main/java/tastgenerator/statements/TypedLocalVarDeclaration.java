package tastgenerator.statements;

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
    public TypedLocalVarDeclaration(ObjectType variableType, String name, ObjectType objectType)
    {
        this.variableType = variableType;
        this.name = name;
        setObjectType(objectType);
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
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {
        Generator.generate(this, visitor, localVar);
    }
}
