package tastgenerator.expressions;

import common.ObjectType;
import bytecodegenerator.Context;
import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class TypedMethodCallExpression extends TypedExpression
{
    private TypedExpression object;
    private String name;
    private List<TypedExpression> parameters;

    public TypedMethodCallExpression(TypedExpression object, String name, List<TypedExpression> parameters, ObjectType objectType)
    {
        this.object = object;
        this.name = name;
        this.parameters = parameters;
        this.objectType = objectType;
    }

    public TypedExpression getObject()
    {
        return object;
    }

    public String getName()
    {
        return name;
    }

    public List<TypedExpression> getParameters()
    {
        return parameters;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {

    }
}
