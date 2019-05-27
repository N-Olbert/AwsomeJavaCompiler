package astgenerator.parser.astgen;

import astgenerator.expressions.AssignExpression;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.AssignStatement;

public class AssignExpressionGenerator {

    public static AssignExpression generate(awsomeJavaParser.AssignContext assignContext){
        return new AssignExpression(BasicExpressionGenerator.generate(assignContext.basicexpressions()),
                ExpressionGenerator.generate(assignContext.expression()));
    }

}
