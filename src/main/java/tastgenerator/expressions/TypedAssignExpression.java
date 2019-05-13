package tastgenerator.expressions;

import bytecodegenerator.Context;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class TypedAssignExpression extends TypedExpression
{
    private String name;
    private TypedExpression expression;

    public TypedAssignExpression(String name, TypedExpression expression) {
        this.name = name;
        this.expression = expression;
    }

    public String getName() {
        return this.name;
    }

    public TypedExpression getExpression() {
        return this.expression;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {

    }
}
