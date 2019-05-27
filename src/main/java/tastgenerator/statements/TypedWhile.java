package tastgenerator.statements;

import bytecodegenerator.Context;
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

    public TypedBlock getStmt()
    {
        return stmt;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        if (!super.equals(o))
        {
            return false;
        }

        TypedWhile that = (TypedWhile) o;

        if (exp != null ? !exp.equals(that.exp) : that.exp != null)
        {
            return false;
        }
        return stmt != null ? stmt.equals(that.stmt) : that.stmt == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (exp != null ? exp.hashCode() : 0);
        result = 31 * result + (stmt != null ? stmt.hashCode() : 0);
        return result;
    }
}
