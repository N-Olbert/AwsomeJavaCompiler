package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.ExpressionBCGenerator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedInstVar extends TypedExpression {
    private String name;
    private TypedExpression expression;

    public TypedInstVar(TypedExpression expression, String name, ObjectType objectType) {
        this.expression = expression;
        this.name = name;
        this.objectType = objectType;
    }

    public String getName() {
        return name;
    }

    public TypedExpression getExpression() {
        return expression;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        ExpressionBCGenerator.generate(this, visitor, context);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        if(!super.equals(o)) {
            return false;
        }

        TypedInstVar that = (TypedInstVar) o;

        if(name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return super.equals(o) && expression != null ? expression.equals(that.expression) : that.expression == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (expression != null ? expression.hashCode() : 0);
        return result;
    }
}
