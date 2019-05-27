package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.parser.generated.awsomeJavaParser;

public class ExpressionGenerator {

    public static Expression generate(awsomeJavaParser.ExpressionContext expressionContext){
        if (expressionContext.binary() != null){
            return null;
        } else if (expressionContext.basicexpressions() != null){
            return BasicExpressionGenerator.generate(expressionContext.basicexpressions());
        } else { //statementExpression
            awsomeJavaParser.StatementExpressionsContext statementExpressionsContext =
                    expressionContext.statementExpressions();

            if (statementExpressionsContext.assign() != null){
                return AssignExpressionGenerator.generate(statementExpressionsContext.assign());
            } else if (statementExpressionsContext.methodCall() != null){
                return MethodCallExpressionGenerator.generate(statementExpressionsContext.methodCall());
            } else { //New
                return NewExpressionGenerator.generate(statementExpressionsContext.jNew());
            }
        }
    }
}
