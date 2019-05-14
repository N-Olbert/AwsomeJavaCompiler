package tastgenerator.expressions;


import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

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
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
