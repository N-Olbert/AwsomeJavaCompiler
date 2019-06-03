package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.expressions.Unary;
import astgenerator.parser.generated.awsomeJavaParser;

public class ExpressionGenerator {

    public static Expression generate(awsomeJavaParser.ExpressionContext expressionContext){
        if (expressionContext.basicexpressions() != null) {
            return BasicExpressionGenerator.generate(expressionContext.basicexpressions());
        } else { //binary
            return BinaryGenerator.generate(expressionContext.binary());
        }
    }
}
