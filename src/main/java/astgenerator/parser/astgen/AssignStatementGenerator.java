package astgenerator.parser.astgen;

import astgenerator.expressions.Binary;
import astgenerator.expressions.InstVar;
import astgenerator.expressions.JInteger;
import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.AssignStatement;
import common.Operators;

public class AssignStatementGenerator {

    public static AssignStatement generate(awsomeJavaParser.AssignContext assignContext){

        if (assignContext.Equal() != null) {
            if (assignContext.instVar() != null) {
                return new AssignStatement(InstVarGenerator.generate(assignContext.instVar()),
                        ExpressionGenerator.generate(assignContext.expression()));
            } else { //localOrFieldVar
                return new AssignStatement(new LocalOrFieldVar(assignContext.Identifier().getText()),
                        ExpressionGenerator.generate(assignContext.expression()));
            }
        } else {

            Operators operator;

            if (assignContext.PlusEqual() != null){
                operator = Operators.PLUS;
            } else { //MinusEqual
                operator = Operators.MINUS;
            }

            if (assignContext.instVar() != null) {
                InstVar instVar = InstVarGenerator.generate(assignContext.instVar());
                return new AssignStatement(instVar, new Binary(instVar,
                        ExpressionGenerator.generate(assignContext.expression()), operator));
            } else { //localOrFieldVar
                LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar(assignContext.Identifier().getText());
                return new AssignStatement(localOrFieldVar,
                        new Binary(localOrFieldVar, new JInteger("1"), operator));
            }
        }
    }
}
