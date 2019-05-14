package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedInstVar extends TypedExpression
{
    private String name;
    private TypedExpression expression;
    public TypedInstVar(TypedExpression expression, String name, ObjectType objectType){
        this.expression = expression;
        this.name = name;
        this.objectType = objectType;
    }

    public String getName()
    {
        return name;
    }

    public TypedExpression getExpression()
    {
        return expression;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
