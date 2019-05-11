package tastgenerator.expressions;

import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class TypedMethodCallExpression extends TypedExpression
{
    private TypedExpression object;
    private String name;
    private List<TypedExpression> parameters;

    public TypedMethodCallExpression(TypedExpression object, String name, List<TypedExpression> parameters)
    {
        this.object = object;
        this.name = name;
        this.parameters = parameters;
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
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {

    }
}
