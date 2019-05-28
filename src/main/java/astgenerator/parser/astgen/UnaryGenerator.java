package astgenerator.parser.astgen;

import astgenerator.expressions.*;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.Block;
import astgenerator.statements.Return;
import common.Operators;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnaryGenerator {

    public static Expression generate(awsomeJavaParser.UnaryContext unaryContext) throws ExecutionControl.NotImplementedException {

        if(unaryContext.operatorBeforeExpr()!=null) {
            String operator = unaryContext.operatorBeforeExpr().Identifier().getText();

            Expression identifier;

            if (unaryContext.operatorBeforeExpr().Identifier() != null) {
                identifier = new LocalOrFieldVar(unaryContext.operatorBeforeExpr().Identifier().getText());
            } else {
                identifier = InstVarGenerator.generate(unaryContext.operatorBeforeExpr().instVar());
            }

            if (("!".equals(operator))) {
                return new Unary(identifier,OperatorGenerator.generate(unaryContext.operatorBeforeExpr().Identifier()));
            } else if ("++".equals(operator)){
                return new AssignExpression(identifier, new Binary(identifier,new JInteger("1"),Operators.PLUS));
            } else { //--
                return new AssignExpression(identifier, new Binary(identifier, new JInteger("1"),Operators.MINUS));
            }

        } else { //operator after expression
            String operator = unaryContext.operatorAfterExpr().Identifier().getText();

            Expression identifier;

            if (unaryContext.operatorAfterExpr().Identifier() != null) {
                identifier = new LocalOrFieldVar(unaryContext.operatorAfterExpr().Identifier().getText());
            } else {
                identifier = InstVarGenerator.generate(unaryContext.operatorAfterExpr().instVar());
            }

            if ("++".equals(operator)) {
                throw new ExecutionControl.NotImplementedException("Increment after not implemented");
            } else { //--
                throw new ExecutionControl.NotImplementedException("Incremented before not implemented");
            }

        }
    }
}