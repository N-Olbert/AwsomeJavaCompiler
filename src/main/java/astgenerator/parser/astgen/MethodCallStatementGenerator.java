package astgenerator.parser.astgen;

import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.expressions.This;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.MethodCallStatement;

public class MethodCallStatementGenerator {

    static MethodCallStatement generate(awsomeJavaParser.MethodCallContext methodCallContext){

        if (methodCallContext.Dot() != null){
            if (methodCallContext.instVar() != null){
                return new MethodCallStatement(InstVarGenerator.generate(methodCallContext.instVar()),
                        methodCallContext.Identifier().get(0).getText(),
                        ArgumentGenerator.generate(methodCallContext.nArguments()));
            } else {
                return new MethodCallStatement(new LocalOrFieldVar(methodCallContext.Identifier().get(0).getText()),
                        methodCallContext.Identifier().get(1).getText(),
                        ArgumentGenerator.generate(methodCallContext.nArguments()));
            }
        } else {
            return new MethodCallStatement(new This(),
                    methodCallContext.Identifier(0).getText(),
                    ArgumentGenerator.generate(methodCallContext.nArguments()));
        }
    }
}
