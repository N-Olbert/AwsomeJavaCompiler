package astgenerator.parser.astgen;

import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.LocalVarDeclaration;
import astgenerator.statements.MethodCallStatement;
import astgenerator.statements.NewStatement;
import astgenerator.statements.Statement;

public class StatementGenerator {
    public static Statement generate(awsomeJavaParser.StatementContext statementContext){

        if(statementContext.ifelse() != null){
            return IfElseGenerator.generate(statementContext.ifelse());
        } else if (statementContext.block() != null){
            return BlockGenerator.generate(statementContext.block());
        } else if (statementContext.jReturn() != null){
            return ReturnGenerator.generate(statementContext.jReturn());
        } else if (statementContext.jWhile() != null) {
            return WhileGenerator.generate(statementContext.jWhile());
        } else if (statementContext.localVarDeclaration() != null) {
            return LocalVarDeclarationGenerator.generate(statementContext.localVarDeclaration());
        } else { //statementeExpression
            awsomeJavaParser.StatementExpressionsContext statementExpressionsContext =
                    statementContext.statementExpressions();
            if (statementExpressionsContext.methodCall() != null){
                return MethodCallStatementGenerator.generate(statementExpressionsContext.methodCall());
            } else if (statementExpressionsContext.assign() != null){
                return AssignStatementGenerator.generate(statementExpressionsContext.assign());
            } else { //new
                return NewStatementGenerator.generate(statementExpressionsContext.jNew());
            }
        }

    }
}
