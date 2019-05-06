package tastgenerator.expressions;


import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedBoolean extends TypedExpression
{
    private boolean jBool;

    public TypedBoolean(String jBool){
        this.jBool = Boolean.parseBoolean(jBool);
        this.objectType = ObjectType.BoolType;
    }

    public boolean getJBool(){
        return jBool;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
