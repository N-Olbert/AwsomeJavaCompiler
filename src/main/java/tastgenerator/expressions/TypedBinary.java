package tastgenerator.expressions;

import common.ObjectType;
import bytecodegenerator.Generator;
import common.Operators;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedBinary extends TypedExpression
{
    private TypedExpression expression;
    private TypedExpression expression2;
    private Operators operator;
    public TypedBinary(TypedExpression expression, TypedExpression expression2, Operators operator, ObjectType objectType)
    {
        this.expression = expression;
        this.expression2 = expression2;
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

    public TypedExpression getExpression2()
    {
        return expression2;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {
        Generator.generate(this, visitor, localVar);
    }
}
