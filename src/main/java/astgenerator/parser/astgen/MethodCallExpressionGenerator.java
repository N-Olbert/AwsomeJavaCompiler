package astgenerator.parser.astgen;

import astgenerator.expressions.InstVar;
import astgenerator.expressions.MethodCallExpression;
import astgenerator.parser.generated.awsomeJavaParser;
import org.codehaus.plexus.util.cli.Commandline;

public class MethodCallExpressionGenerator {

    public static MethodCallExpression generate(awsomeJavaParser.MethodCallContext methodCallContext){

        InstVar instVar = null;

        if (methodCallContext.instVar() != null) {
            instVar = InstVarGenerator.generate(methodCallContext.instVar());
        }

        return new MethodCallExpression(instVar,
                methodCallContext.Identifier().getText(),
                ArgumentGenerator.generate(methodCallContext.nArguments()));
    }

}
