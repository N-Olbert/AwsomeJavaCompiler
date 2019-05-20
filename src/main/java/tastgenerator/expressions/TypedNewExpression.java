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
        this.objectType = ObjectType.VoidType;
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
}
