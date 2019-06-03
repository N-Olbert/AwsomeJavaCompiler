package tastgenerator.expressions;

import bytecodegenerator.Context;
import bytecodegenerator.ExpressionBCGenerator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

public class TypedNull extends TypedExpression {
    public TypedNull() {
        this.objectType = ObjectType.NullType;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        ExpressionBCGenerator.generate(this, visitor, context);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && o instanceof TypedNull;
    }
}
