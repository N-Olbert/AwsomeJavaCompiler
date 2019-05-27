package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
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
        Generator.generate(this, visitor, context);
    }
}
