package tastgenerator.expressions;

import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.statementexpressions.TypedStatementExpression;

public class TypedStatementExpressionExpression extends TypedExpression
{
    private TypedStatementExpression stmtExpr;

    public TypedStatementExpressionExpression(TypedStatementExpression stmtExpr)
    {
        this.stmtExpr = stmtExpr;
    }

    public TypedStatementExpression getStmtExpr()
    {
        return stmtExpr;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
