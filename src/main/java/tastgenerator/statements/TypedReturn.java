package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.StatementBCGenerator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

public class TypedReturn extends TypedStatement {
    private TypedExpression exp;

    public TypedReturn(TypedExpression exp, ObjectType objectType) {
        this.exp = exp;
        this.objectType = objectType;
    }

    public TypedReturn(ObjectType objectType) {
        this.objectType = objectType;
    }

    public TypedExpression getExp() {
        return exp;
    }


    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        StatementBCGenerator.generate(this, visitor, context);
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

        TypedReturn that = (TypedReturn) o;

        return exp != null ? exp.equals(that.exp) : that.exp == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (exp != null ? exp.hashCode() : 0);
        return result;
    }
}
