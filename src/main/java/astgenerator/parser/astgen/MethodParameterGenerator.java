package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.parser.generated.awsomeJavaParser;

import java.util.ArrayList;
import java.util.List;

public class MethodParameterGenerator {

    public static List<Expression> generate(awsomeJavaParser.NArgumentsContext nArgumentsContext){
        List<Expression> expressions = new ArrayList<>();
        nArgumentsContext.expression().forEach(expression ->
                expressions.add(ExpressionGenerator.generate(expression)));
        return expressions;
    }

}
