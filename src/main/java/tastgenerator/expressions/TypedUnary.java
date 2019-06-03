package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.ExpressionBCGenerator;
import common.ObjectType;
import common.Operators;
import org.objectweb.asm.MethodVisitor;

public class TypedUnary extends TypedExpression {
    private TypedExpression expression;
    private Operators operator;

    public TypedUnary(TypedExpression expression, Operators operator, ObjectType objectType) {
        this.expression = expression;
        this.operator = operator;
        this.objectType = objectType;
    }

    public TypedExpression getExpression() {
        return expression;
    }

    public Operators getOperator() {
        return operator;
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

        TypedUnary that = (TypedUnary) o;

        if(expression != null ? !expression.equals(that.expression) : that.expression != null) {
            return false;
        }
        return operator == that.operator;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (expression != null ? expression.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }
}
