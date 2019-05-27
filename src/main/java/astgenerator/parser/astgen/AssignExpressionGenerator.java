package astgenerator.parser.astgen;

import astgenerator.expressions.AssignExpression;
import astgenerator.expressions.Expression;
import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.parser.generated.awsomeJavaParser;

public class AssignExpressionGenerator {

    public static Expression generate(awsomeJavaParser.AssignContext assignContext) {
        if (assignContext.instVar() != null){
            return new AssignExpression(InstVarGenerator.generate(assignContext.instVar()),
                    ExpressionGenerator.generate(assignContext.expression()));
        } else { //localOrFieldVar
            return new AssignExpression(new LocalOrFieldVar(assignContext.Identifier().getText()),
                    ExpressionGenerator.generate(assignContext.expression()));
        }
    }
}
