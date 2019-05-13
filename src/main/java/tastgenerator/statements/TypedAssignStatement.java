package tastgenerator.statements;
import bytecodegenerator.Context;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.Map;

public class TypedAssignStatement extends TypedStatement
{
    private String name;
    private TypedExpression expression;

    public TypedAssignStatement(String name, TypedExpression expression) {
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
