package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

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
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
