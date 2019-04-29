package tastgenerator.statementexpressions;
import tastgenerator.expressions.TypedExpression;

public class TypedAssign extends TypedStatementExpression
{
    private String name;
    private TypedExpression expression;

    public TypedAssign(String name, TypedExpression expression) {
        this.name = name;
        this.expression = expression;
    }

    public String getName() {
        return this.name;
    }

    public TypedExpression getExpression() {
        return this.expression;
    }
}
