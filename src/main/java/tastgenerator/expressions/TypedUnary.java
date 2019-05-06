package tastgenerator.expressions;

import bytecodegenerator.Generator;
import common.Operators;
import org.objectweb.asm.MethodVisitor;

public class TypedUnary extends TypedExpression
{
    private TypedExpression expression;
    private Operators operator;
    public TypedUnary(TypedExpression expression, Operators operator)
    {
        this.expression = expression;
        this.operator = operator;
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
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
