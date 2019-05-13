package tastgenerator.statements;

import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.List;
import java.util.Map;

public class TypedMethodCallStatement extends TypedStatement
{
    private TypedExpression object;
    private String name;
    private List<TypedExpression> parameters;

    public TypedMethodCallStatement(TypedExpression object, String name, List<TypedExpression> parameters, ObjectType objectType)
    {
        this.object = object;
        this.name = name;
        this.parameters = parameters;
        setObjectType(objectType);
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
