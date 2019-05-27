package astgenerator.parser.astgen;

import astgenerator.expressions.AssignExpression;
import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.AssignStatement;

public class AssignStatementGenerator {

    public static AssignStatement generate(awsomeJavaParser.AssignContext assignContext){
        if (assignContext.instVar() != null){
            return new AssignStatement(InstVarGenerator.generate(assignContext.instVar()),
                    ExpressionGenerator.generate(assignContext.expression()));
        } else { //localOrFieldVar
            return new AssignStatement(new LocalOrFieldVar(assignContext.Identifier().getText()),
                    ExpressionGenerator.generate(assignContext.expression()));
        }
    }
}
