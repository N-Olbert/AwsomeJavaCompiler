package tastgenerator.statements;

import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

public class TypedReturn extends TypedStatement
{
    private TypedExpression exp;
    public TypedReturn(TypedExpression exp)
    {
        this.exp = exp;
    }

    public TypedExpression getExp()
    {
        return exp;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
