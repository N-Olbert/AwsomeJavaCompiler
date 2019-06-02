package astgenerator.parser.astgen;

import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.expressions.MethodCallExpression;
import astgenerator.expressions.This;
import astgenerator.parser.generated.awsomeJavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class MethodCallExpressionGenerator {

    public static MethodCallExpression generate(awsomeJavaParser.MethodCallContext methodCallContext) {

        MethodCallExpression methodCall = generateMethodCall(methodCallContext.Identifier(),methodCallContext.nArguments(),
                methodCallContext.Identifier().size()-1);

        if (methodCallContext.methodCallPrefix() != null) {
            if (methodCallContext.methodCallPrefix().instVar() != null){
                methodCall = new MethodCallExpression(
                        InstVarGenerator.generate(methodCallContext.methodCallPrefix().instVar()),
                        methodCall.getName(),
                        methodCall.getParameters());
            } else { //Identifier
                methodCall = new MethodCallExpression(
                        new LocalOrFieldVar(methodCallContext.methodCallPrefix().Identifier().getText()),
                        methodCall.getName(),
                        methodCall.getParameters());
            }
        }

        return methodCall;

    }

    private static MethodCallExpression generateMethodCall(List<TerminalNode> contexts,
                                                    List<awsomeJavaParser.NArgumentsContext> arguments,
                                                    int position){
        if (position > 0){
            return new MethodCallExpression(generateMethodCall(contexts,arguments,position-1),
                    contexts.get(position).getText(), ArgumentGenerator.generate(arguments.get(position)));
        } else {
            return new MethodCallExpression(new This(),contexts.get(0).getText(),
                    ArgumentGenerator.generate(arguments.get(0)));
        }
    }
}
