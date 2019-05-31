package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.List;

public class TypedNewStatement extends TypedStatement {
    private ObjectType newType;
    private List<TypedExpression> parameters;

    public TypedNewStatement(ObjectType newType, List<TypedExpression> expressions) {
        this.newType = newType;
        this.parameters = expressions;
        this.objectType = ObjectType.VoidType;
    }

    public ObjectType getNewType() {
        return newType;
    }

    public List<TypedExpression> getParameters() {
        return parameters;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
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

        TypedNewStatement that = (TypedNewStatement) o;

        if(newType != null ? !newType.equals(that.newType) : that.newType != null) {
            return false;
        }
        return parameters != null ? parameters.equals(that.parameters) : that.parameters == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (newType != null ? newType.hashCode() : 0);
        result = 31 * result + (parameters != null ? parameters.hashCode() : 0);
        return result;
    }
}
