package tastgenerator.statements;
import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.Map;

public class TypedAssignStatement extends TypedStatement
{
    private TypedExpression expression1;
    private TypedExpression expression2;

    public TypedAssignStatement(TypedExpression expression1, TypedExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
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
