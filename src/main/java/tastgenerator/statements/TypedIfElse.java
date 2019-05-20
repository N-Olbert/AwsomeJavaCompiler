package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.HashMap;
import java.util.Map;

public class TypedIfElse extends TypedStatement
{
    private TypedExpression condition;
    private TypedBlock then;
    private TypedBlock otherwise;

    public TypedIfElse(TypedExpression condition, TypedBlock then, TypedBlock otherwise, ObjectType objectType)
    {
        this.condition = condition;
        this.then = then;
        this.otherwise = otherwise;
        this.objectType = objectType;
    }

    public TypedExpression getCondition()
    {
        return condition;
    }

    public TypedBlock getThen()
    {
        return then;
    }

    public TypedBlock getOtherwise()
    {
        return otherwise;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
