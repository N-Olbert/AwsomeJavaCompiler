package tastgenerator.statements;

import bytecodegenerator.Context;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.List;
import java.util.Map;

public class TypedNewStatement extends TypedStatement
{
    private ObjectType newType;
    private List<TypedExpression> parameters;

    public TypedNewStatement(ObjectType newType, List<TypedExpression> expressions)
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
}
