package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.NewStatement;
import common.ObjectType;

import java.util.ArrayList;
import java.util.List;

public class NewStatementGenerator {

    public static NewStatement generate(awsomeJavaParser.JNewContext newContext){

        List<Expression> methodParameters = new ArrayList<>();

        newContext.nArguments().expression().forEach(argument ->
                methodParameters.add(ExpressionGenerator.generate(argument)));

        return new NewStatement(ObjectType.getType(newContext.Identifier().getText()),methodParameters);
    }
}
