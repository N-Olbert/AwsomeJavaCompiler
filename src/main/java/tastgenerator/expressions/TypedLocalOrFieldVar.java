package tastgenerator.expressions;

import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

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
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }

}
