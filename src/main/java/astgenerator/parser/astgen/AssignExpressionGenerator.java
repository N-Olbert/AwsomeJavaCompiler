package astgenerator.parser.astgen;

import astgenerator.expressions.*;
import astgenerator.parser.generated.awsomeJavaParser;
import common.Operators;

public class AssignExpressionGenerator {

    public static Expression generate(awsomeJavaParser.AssignContext assignContext) {
        if (assignContext.Equal() != null) {
            if (assignContext.instVar() != null) {
                return new AssignExpression(InstVarGenerator.generate(assignContext.instVar()),
                        ExpressionGenerator.generate(assignContext.expression()));
            } else { //localOrFieldVar
                return new AssignExpression(new LocalOrFieldVar(assignContext.Identifier().getText()),
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
                return new AssignExpression(instVar, new Binary(instVar,
                        ExpressionGenerator.generate(assignContext.expression()), operator));
            } else { //localOrFieldVar
                LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar(assignContext.Identifier().getText());
                return new AssignExpression(localOrFieldVar,
                        new Binary(localOrFieldVar, new JInteger("1"), operator));
            }
        }
    }
}
