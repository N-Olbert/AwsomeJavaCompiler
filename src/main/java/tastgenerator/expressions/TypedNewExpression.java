package tastgenerator.expressions;

import bytecodegenerator.Context;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class TypedNewExpression extends TypedExpression
{
    private ObjectType newType;
    private List<TypedExpression> parameters;

    public TypedNewExpression(ObjectType newType, List<TypedExpression> expressions)
    {
        this.newType = newType;
        this.parameters = expressions;
        this.objectType = newType;
    }

    public ObjectType getNewType()
    {
        return newType;
    }

    public List<TypedExpression> getParameters()
    {
        return parameters;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {

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

        TypedNewExpression that = (TypedNewExpression) o;

        if (newType != null ? !newType.equals(that.newType) : that.newType != null)
        {
            return false;
        }
        return super.equals(o) && parameters != null ? parameters.equals(that.parameters) : that.parameters == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (newType != null ? newType.hashCode() : 0);
        result = 31 * result + (parameters != null ? parameters.hashCode() : 0);
        return result;
    }
}
