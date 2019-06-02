package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.ExpressionBCGenerator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedLocalOrFieldVar extends TypedExpression {
    private String name;

    public TypedLocalOrFieldVar(ObjectType objectType, String name) {
        this.objectType = objectType;
        this.name = name;
    }

    public String getName() {
        return name;
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

        TypedLocalOrFieldVar that = (TypedLocalOrFieldVar) o;

        return super.equals(o) && name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
