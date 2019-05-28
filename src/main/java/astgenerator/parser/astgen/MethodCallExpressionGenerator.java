package astgenerator.parser.astgen;

import astgenerator.expressions.MethodCallExpression;
import astgenerator.expressions.This;
import astgenerator.parser.generated.awsomeJavaParser;

public class MethodCallExpressionGenerator {

    public static MethodCallExpression generate(awsomeJavaParser.MethodCallContext methodCallContext){

        if (methodCallContext.instVar() != null) {
            return new MethodCallExpression(InstVarGenerator.generate(methodCallContext.instVar()),
                    methodCallContext.Identifier().getText(),
                    ArgumentGenerator.generate(methodCallContext.nArguments()));
        } else {
            return new MethodCallExpression(new This(),
                    methodCallContext.Identifier().getText(),
                    ArgumentGenerator.generate(methodCallContext.nArguments()));
        }


    }

}
