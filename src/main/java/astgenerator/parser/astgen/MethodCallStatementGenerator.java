package astgenerator.parser.astgen;

import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.expressions.MethodCallExpression;
import astgenerator.expressions.This;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.MethodCallStatement;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class MethodCallStatementGenerator {

    public static MethodCallStatement generate(awsomeJavaParser.MethodCallContext methodCallContext) {

        MethodCallExpression methodCallTemp = (MethodCallExpression) generateMethodCall(methodCallContext.Identifier(),
                methodCallContext.nArguments(), methodCallContext.Identifier().size()-1);

        MethodCallStatement methodCall = new MethodCallStatement(methodCallTemp.getObject(),methodCallTemp.getName(),
                methodCallTemp.getParameters());

        if (methodCallContext.methodCallPrefix() != null) {
            if (methodCallContext.methodCallPrefix().instVar() != null){
                methodCall = new MethodCallStatement(
                        InstVarGenerator.generate(methodCallContext.methodCallPrefix().instVar()),
                        methodCall.getName(),
                        methodCall.getParameters());
            } else { //Identifier
                methodCall = new MethodCallStatement(
                        new LocalOrFieldVar(methodCallContext.methodCallPrefix().Identifier().getText()),
                        methodCall.getName(),
                        methodCall.getParameters());
            }
        }

        return methodCall;

    }

    private static Object generateMethodCall(List<TerminalNode> contexts,
                                                           List<awsomeJavaParser.NArgumentsContext> arguments,
                                                           int position){
        if (position > 0){
            return new MethodCallStatement((MethodCallExpression) generateMethodCall(contexts,arguments,position-1),
                    contexts.get(position).getText(), ArgumentGenerator.generate(arguments.get(position)));
        } else {
            return new MethodCallExpression(new This(),contexts.get(0).getText(),
                    ArgumentGenerator.generate(arguments.get(0)));
        }
    }
}
