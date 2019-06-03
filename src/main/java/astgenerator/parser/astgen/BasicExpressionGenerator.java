package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.parser.generated.awsomeJavaParser;

class BasicExpressionGenerator {

    static Expression generate(awsomeJavaParser.BasicexpressionsContext basicexpressionsContext){
        if (basicexpressionsContext.baseType() != null){
            return BaseTypeGenerator.generate(basicexpressionsContext.baseType());
        } else if (basicexpressionsContext.instVar() != null){
            return InstVarGenerator.generate(basicexpressionsContext.instVar());
        } else  if (basicexpressionsContext.Identifier() != null) {
            return new LocalOrFieldVar(basicexpressionsContext.Identifier().getText());
        } else if (basicexpressionsContext.expression() != null) {
            return ExpressionGenerator.generate(basicexpressionsContext.expression());
        } else if (basicexpressionsContext.unary() != null){
                return UnaryGenerator.generate(basicexpressionsContext.unary());
        } else { //statementExpression
            awsomeJavaParser.StatementExpressionsContext statementExpressionsContext =
                    basicexpressionsContext.statementExpressions();
            if (statementExpressionsContext.assign() != null) {
                return AssignExpressionGenerator.generate(statementExpressionsContext.assign());
            } else if (statementExpressionsContext.methodCall() != null) {
                return MethodCallExpressionGenerator.generate(statementExpressionsContext.methodCall());
            } else { //New
                return NewExpressionGenerator.generate(statementExpressionsContext.jNew());
            }
        }
    }
}
