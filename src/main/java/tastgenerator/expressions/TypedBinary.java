package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.ExpressionBCGenerator;
import common.ObjectType;
import common.Operators;
import org.objectweb.asm.MethodVisitor;

public class TypedBinary extends TypedExpression {
    private TypedExpression expression;
    private TypedExpression expression2;
    private Operators operator;

    public TypedBinary(TypedExpression expression, TypedExpression expression2, Operators operator,
                       ObjectType objectType) {
        this.expression = expression;
        this.expression2 = expression2;
        this.operator = operator;
        this.objectType = objectType;
    }

    public TypedExpression getExpression() {
        return expression;
    }

    public Operators getOperator() {
        return operator;
    }

    public TypedExpression getExpression2() {
        return expression2;
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

        TypedBinary that = (TypedBinary) o;

        if(expression != null ? !expression.equals(that.expression) : that.expression != null) {
            return false;
        }
        if(expression2 != null ? !expression2.equals(that.expression2) : that.expression2 != null) {
            return false;
        }
        return operator == that.operator;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (expression != null ? expression.hashCode() : 0);
        result = 31 * result + (expression2 != null ? expression2.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }
}
