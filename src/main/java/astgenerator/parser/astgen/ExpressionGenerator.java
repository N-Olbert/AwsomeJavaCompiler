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
                awsomeJavaParser.StatementExpressionsContext expressionsContext =
                        expressionContext.statementExpressions();

                if (expressionsContext.assign() != null){
                    return AssignExpressionGenerator.generate(expressionsContext.assign());
                } else if (expressionsContext.methodCall() != null){
                    return MethodCallExpressionGenerator.generate(expressionsContext.methodCall());
                } else {
                    return NewExpressionGenerator();
                }
            }
        }
    }
}
