package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.ExpressionBCGenerator;
import org.objectweb.asm.MethodVisitor;

public class TypedAssignExpression extends TypedExpression {
    private TypedExpression expression1;
    private TypedExpression expression2;

    public TypedAssignExpression(TypedExpression expression1, TypedExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.objectType = expression1.getObjectType();
    }

    public TypedExpression getExpression1() {
        return this.expression1;
    }

    public TypedExpression getExpression2() {
        return this.expression2;
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

        TypedAssignExpression that = (TypedAssignExpression) o;

        if(expression1 != null ? !expression1.equals(that.expression1) : that.expression1 != null) {
            return false;
        }
        return expression2 != null ? expression2.equals(that.expression2) : that.expression2 == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (expression1 != null ? expression1.hashCode() : 0);
        result = 31 * result + (expression2 != null ? expression2.hashCode() : 0);
        return result;
    }
}
