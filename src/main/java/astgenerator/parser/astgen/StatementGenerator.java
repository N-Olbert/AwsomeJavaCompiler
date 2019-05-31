package astgenerator.parser.astgen;

import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.*;
import edu.emory.mathcs.backport.java.util.Collections;

import java.util.ArrayList;
import java.util.List;

public class StatementGenerator {
    public static List<Statement> generate(awsomeJavaParser.StatementContext statementContext){

        List<Statement> statements = new ArrayList<>();

        if(statementContext.ifelse() != null){
            statements.add(IfElseGenerator.generate(statementContext.ifelse()));
        } else if (statementContext.block() != null){
            statements.add(BlockGenerator.generate(statementContext.block()));
        } else if (statementContext.jReturn() != null){
            statements.add(ReturnGenerator.generate(statementContext.jReturn()));
        } else if (statementContext.jWhile() != null) {
            statements.add(WhileGenerator.generate(statementContext.jWhile()));
        } else if (statementContext.localVarDeclaration() != null) {
            statements.add(LocalVarDeclarationGenerator.generate(statementContext.localVarDeclaration()));

            if (statementContext.localVarDeclaration().expression() != null) {
                statements.add(new AssignStatement(
                        new LocalOrFieldVar(statementContext.localVarDeclaration().Identifier().getText()),
                        ExpressionGenerator.generate(statementContext.localVarDeclaration().expression())));
            }
        } else { //statementeExpression
            awsomeJavaParser.StatementExpressionsContext statementExpressionsContext =
                    statementContext.statementExpressions();
            if (statementExpressionsContext.methodCall() != null){
                statements.add(MethodCallStatementGenerator.generate(statementExpressionsContext.methodCall()));
            } else if (statementExpressionsContext.assign() != null){
                statements.add(AssignStatementGenerator.generate(statementExpressionsContext.assign()));
            } else { //new
                statements.add(NewStatementGenerator.generate(statementExpressionsContext.jNew()));
            }
        }

        return statements;

    }
}
