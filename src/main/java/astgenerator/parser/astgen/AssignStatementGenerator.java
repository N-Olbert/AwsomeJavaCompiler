package astgenerator.parser.astgen;

import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.AssignStatement;

public class AssignStatementGenerator {

    public static AssignStatement generate(awsomeJavaParser.AssignContext assignContext){
        return new AssignStatement(BasicExpressionGenerator.generate(assignContext.basicexpressions()),
                ExpressionGenerator.generate(assignContext.expression()));
    }
}
