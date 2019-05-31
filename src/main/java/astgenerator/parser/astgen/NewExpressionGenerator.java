package astgenerator.parser.astgen;

import astgenerator.expressions.NewExpression;
import astgenerator.parser.generated.awsomeJavaParser;
import common.ObjectType;

public class NewExpressionGenerator {

    public static NewExpression generate(awsomeJavaParser.JNewContext jNewContext){
        return new NewExpression(ObjectType.getType(jNewContext.Identifier().getText()),
                MethodParameterGenerator.generate(jNewContext.nArguments()));
    }

}
