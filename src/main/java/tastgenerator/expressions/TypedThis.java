package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedThis extends TypedExpression
{

    public TypedThis(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
