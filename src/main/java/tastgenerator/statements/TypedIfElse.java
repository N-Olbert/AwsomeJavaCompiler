package tastgenerator.statements;

import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.HashMap;
import java.util.Map;

public class TypedIfElse extends TypedStatement
{
    private TypedExpression condition;
    private TypedBlock then;
    private TypedBlock otherwise;

    public TypedIfElse(TypedExpression condition, TypedBlock then, TypedBlock otherwise)
    {
        this.condition = condition;
        this.then = then;
        this.otherwise = otherwise;
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
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {
        Generator.generate(this, visitor, localVar);
    }
}
