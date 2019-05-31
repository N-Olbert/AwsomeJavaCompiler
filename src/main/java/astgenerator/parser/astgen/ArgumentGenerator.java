package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.parser.generated.awsomeJavaParser;

import java.util.ArrayList;
import java.util.List;

public class ArgumentGenerator {

    public static List<Expression> generate(awsomeJavaParser.NArgumentsContext nArgumentsContext){
        List<Expression> expressions = new ArrayList<>();
        nArgumentsContext.expression().forEach(expressionContext ->
                expressions.add(ExpressionGenerator.generate(expressionContext)));
        return expressions;
    }

}
