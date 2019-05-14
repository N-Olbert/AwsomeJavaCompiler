package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.HashMap;
import java.util.Map;

public class TypedReturn extends TypedStatement
{
    private TypedExpression exp;
    public TypedReturn(TypedExpression exp, ObjectType objectType)
    {
        this.exp = exp;
        this.objectType = objectType;
    }

    public TypedExpression getExp()
    {
        return exp;
    }


    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
