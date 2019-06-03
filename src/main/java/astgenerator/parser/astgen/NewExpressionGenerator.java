package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.expressions.NewExpression;
import astgenerator.parser.generated.awsomeJavaParser;
import common.ObjectType;

import java.util.ArrayList;
import java.util.List;

public class NewExpressionGenerator {

    public static NewExpression generate(awsomeJavaParser.JNewContext jNewContext){
        List<Expression> methodParameters = new ArrayList<>();

        jNewContext.nArguments().expression().forEach(argument ->
                methodParameters.add(ExpressionGenerator.generate(argument)));

        return new NewExpression(ObjectType.getType(jNewContext.Identifier().getText()),methodParameters);
    }

}
