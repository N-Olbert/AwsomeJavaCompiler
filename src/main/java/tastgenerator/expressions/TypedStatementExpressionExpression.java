package tastgenerator.expressions;

import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.statementexpressions.TypedStatementExpression;

import java.util.HashMap;
import java.util.Map;

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
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {
        Generator.generate(this, visitor, localVar);
    }
}
