package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.ExpressionBCGenerator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedString extends TypedExpression {
    private String jString;

    public TypedString(String jString) {
        this.jString = jString;
        this.objectType = ObjectType.StringType;
    }

    public String getJString() {
        return jString;
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

        TypedString that = (TypedString) o;

        return super.equals(o) && jString != null ? jString.equals(that.jString) : that.jString == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (jString != null ? jString.hashCode() : 0);
        return result;
    }
}
