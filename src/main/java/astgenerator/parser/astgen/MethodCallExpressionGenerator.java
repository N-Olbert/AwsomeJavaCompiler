package astgenerator.parser.astgen;

import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.expressions.MethodCallExpression;
import astgenerator.expressions.This;
import astgenerator.parser.generated.awsomeJavaParser;

public class MethodCallExpressionGenerator {

    public static MethodCallExpression generate(awsomeJavaParser.MethodCallContext methodCallContext){

        if (methodCallContext.Dot() != null){
            if (methodCallContext.instVar() != null){
                return new MethodCallExpression(InstVarGenerator.generate(methodCallContext.instVar()),
                        methodCallContext.Identifier().get(0).getText(),
                        ArgumentGenerator.generate(methodCallContext.nArguments()));
            } else {
                return new MethodCallExpression(new LocalOrFieldVar(methodCallContext.Identifier().get(0).getText()),
                        methodCallContext.Identifier().get(1).getText(),
                        ArgumentGenerator.generate(methodCallContext.nArguments()));
            }
        } else {
            return new MethodCallExpression(new This(),
                    methodCallContext.Identifier(0).getText(),
                    ArgumentGenerator.generate(methodCallContext.nArguments()));
        }
    }

}
