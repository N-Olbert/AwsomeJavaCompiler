package tastgenerator.statements;

import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.HashMap;
import java.util.Map;

public class TypedWhile extends TypedStatement
{
    private TypedExpression exp;
    private TypedBlock stmt;

    public TypedWhile(TypedExpression exp, TypedBlock stmt, ObjectType objectType)
    {
        this.exp = exp;
        this.stmt = stmt;
        this.objectType = objectType;
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
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {
        Generator.generate(this, visitor, localVar);
    }
}
