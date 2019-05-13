package tastgenerator.statements;

import bytecodegenerator.Context;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.List;
import java.util.Map;

public class TypedMethodCallStatement extends TypedStatement
{
    private TypedExpression object;
    private String name;
    private List<TypedExpression> parameters;

    public TypedMethodCallStatement(TypedExpression object, String name, List<TypedExpression> parameters)
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
    public void generateByteCode(MethodVisitor visitor, Context context) {

    }
}
