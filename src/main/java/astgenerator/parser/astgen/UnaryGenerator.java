package astgenerator.parser.astgen;

import astgenerator.expressions.Unary;
import astgenerator.parser.generated.awsomeJavaParser;
import common.Operators;

public class UnaryGenerator {

    public static Unary generate(awsomeJavaParser.UnaryContext unaryContext){
        if (unaryContext.NotOperator() != null){
            return new Unary(ExpressionGenerator.generate(unaryContext.expression()), Operators.NEGATION);
        }
        return null;
    }

}
