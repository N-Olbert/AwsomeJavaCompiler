package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class TypedAssignExpression extends TypedExpression
{
    private TypedExpression expression1;
    private TypedExpression expression2;

    public TypedAssignExpression(TypedExpression expression1, TypedExpression expression2, ObjectType objectType) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.objectType = objectType;
    }

    public TypedExpression getExpression1() {
        return this.expression1;
    }

    public TypedExpression getExpression2() {
        return this.expression2;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
