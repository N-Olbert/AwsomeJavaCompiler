package tastgenerator.expressions;


import bytecodegenerator.Context;
import bytecodegenerator.ExpressionBCGenerator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedBoolean extends TypedExpression {
    private boolean jBool;

    public TypedBoolean(String jBool) {
        this.jBool = Boolean.parseBoolean(jBool);
        this.objectType = ObjectType.BoolType;
    }

    public boolean getJBool() {
        return jBool;
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

        TypedBoolean that = (TypedBoolean) o;

        return jBool == that.jBool;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (jBool ? 1 : 0);
        return result;
    }
}
