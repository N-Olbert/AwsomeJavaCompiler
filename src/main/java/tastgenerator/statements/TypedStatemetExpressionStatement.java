package tastgenerator.statements;

import bytecodegenerator.Generator;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.statementexpressions.TypedStatementExpression;

import java.util.HashMap;
import java.util.Map;

public class TypedStatemetExpressionStatement extends TypedStatement
{
    private TypedStatementExpression statementExpression;

    public TypedStatemetExpressionStatement(TypedStatementExpression statementExpression)
    {
        this.statementExpression = statementExpression;
    }

    public TypedStatementExpression getStatementExpression()
    {
        return statementExpression;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Map<String, Integer> localVar) {
        Generator.generate(this, visitor, localVar);
    }
}
