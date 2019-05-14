package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.HashMap;
import java.util.Map;

public class TypedWhile extends TypedStatement
{
    private TypedExpression exp;
    private TypedStatement stmt;

    public TypedWhile(TypedExpression exp, TypedStatement stmt)
    {
        this.exp = exp;
        this.stmt = stmt;
    }

    public TypedExpression getExp()
    {
        return exp;
    }

    public TypedStatement getStmt()
    {
        return stmt;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
