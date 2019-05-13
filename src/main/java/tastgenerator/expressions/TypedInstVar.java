package tastgenerator.expressions;

import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedInstVar extends TypedExpression
{
    private String name;
    private TypedExpression expression;
    public TypedInstVar(TypedExpression expression, String name){
        this.expression = expression;
        this.name = name;
    }

    public TypedInstVar(TypedExpression expression, String name, ObjectType objectType){
        this.expression = expression;
        this.name = name;
        setObjectType(expression.objectType);
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
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {
        Generator.generate(this, visitor, localVar);
    }
}
