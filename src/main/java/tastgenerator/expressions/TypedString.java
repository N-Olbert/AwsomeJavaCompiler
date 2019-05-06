package tastgenerator.expressions;

import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedString extends TypedExpression{
    private String jString;

    public TypedString(String jString){
        this.jString = jString;
        this.objectType = ObjectType.StringType;
    }

    public String getJString(){
        return jString;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
