package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.List;

public class TypedMethodCallExpression extends TypedExpression {
    private TypedExpression object;
    private String name;
    private List<TypedExpression> parameters;

    public TypedMethodCallExpression(TypedExpression object, String name, List<TypedExpression> parameters,
                                     ObjectType objectType) {
        this.object = object;
        this.name = name;
        this.parameters = parameters;
        this.objectType = objectType;
    }

    public TypedExpression getObject() {
        return object;
    }

    public String getName() {
        return name;
    }

    public List<TypedExpression> getParameters() {
        return parameters;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
