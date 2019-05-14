package tastgenerator.expressions;

import bytecodegenerator.Context;
import common.ObjectType;
import bytecodegenerator.Generator;
import common.Operators;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedUnary extends TypedExpression
{
    private TypedExpression expression;
    private Operators operator;
    public TypedUnary(TypedExpression expression, Operators operator, ObjectType objectType)
    {
        this.expression = expression;
        this.operator = operator;
        this.objectType = objectType;
    }

    public TypedExpression getExpression()
    {
        return expression;
    }

    public Operators getOperator()
    {
        return operator;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
