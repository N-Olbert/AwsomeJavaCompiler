package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TypedIfElse extends TypedStatement
{
    private TypedExpression condition;
    private TypedBlock then;
    private TypedBlock otherwise;

    public TypedIfElse(TypedExpression condition, TypedBlock then, TypedBlock otherwise, ObjectType objectType)
    {
        this.condition = condition;
        this.then = then;
        this.otherwise = otherwise;
        this.objectType = objectType;
    }

    public TypedIfElse(TypedExpression condition, TypedBlock then, ObjectType objectType) {
        this.condition = condition;
        this.then = then;
        this.otherwise = new TypedBlock(new ArrayList<>(), ObjectType.VoidType);
        this.objectType = objectType;
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

        TypedIfElse that = (TypedIfElse) o;

        if (condition != null ? !condition.equals(that.condition) : that.condition != null)
        {
            return false;
        }
        if (then != null ? !then.equals(that.then) : that.then != null)
        {
            return false;
        }
        return otherwise != null ? otherwise.equals(that.otherwise) : that.otherwise == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (then != null ? then.hashCode() : 0);
        result = 31 * result + (otherwise != null ? otherwise.hashCode() : 0);
        return result;
    }
}
