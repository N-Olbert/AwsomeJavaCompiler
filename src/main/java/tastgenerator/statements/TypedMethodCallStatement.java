package tastgenerator.statements;

import bytecodegenerator.Context;
import bytecodegenerator.StatementBCGenerator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;

import java.util.List;

public class TypedMethodCallStatement extends TypedStatement {
    private TypedExpression object;
    private String name;
    private List<TypedExpression> parameters;

    public TypedMethodCallStatement(TypedExpression object, String name, List<TypedExpression> parameters,
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

        TypedMethodCallStatement that = (TypedMethodCallStatement) o;

        if(object != null ? !object.equals(that.object) : that.object != null) {
            return false;
        }
        if(name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return parameters != null ? parameters.equals(that.parameters) : that.parameters == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (object != null ? object.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parameters != null ? parameters.hashCode() : 0);
        return result;
    }
}
