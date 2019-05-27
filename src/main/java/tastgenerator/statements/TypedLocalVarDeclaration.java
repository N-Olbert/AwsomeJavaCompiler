package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.HashMap;
import java.util.Map;

public class TypedLocalVarDeclaration extends TypedStatement
{
    private ObjectType variableType;
    private String name;
    private TypedExpression expression;

    public TypedLocalVarDeclaration(ObjectType variableType, String name)
    {
        this.variableType = variableType;
        this.name = name;
        this.expression = null;
    }

    public TypedLocalVarDeclaration(ObjectType variableType, String name, TypedExpression expression)
    {
        this.variableType = variableType;
        this.name = name;
        this.expression = expression;
    }

    public ObjectType getVariableType()
    {
        return variableType;
    }

    public String getName()
    {
        return name;
    }

    public TypedExpression getExpression() {
        return expression;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
