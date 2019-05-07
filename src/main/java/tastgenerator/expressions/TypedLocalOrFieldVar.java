package tastgenerator.expressions;

import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedLocalOrFieldVar extends TypedExpression
{
    private String name;
    public TypedLocalOrFieldVar(ObjectType objectType, String name){
        this.objectType = objectType;
        this.name = name;
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
