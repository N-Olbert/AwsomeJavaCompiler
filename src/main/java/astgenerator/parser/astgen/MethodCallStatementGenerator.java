package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.expressions.This;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.MethodCallStatement;

import java.util.ArrayList;
import java.util.List;

public class MethodCallStatementGenerator {

    static MethodCallStatement generate(awsomeJavaParser.MethodCallContext context){

        List<Expression> arguments = new ArrayList<>();
        if (context.nArguments() != null)
            context.nArguments().expression()
                    .forEach(expression -> arguments.add(ExpressionGenerator.generate(expression)));


    }

}
