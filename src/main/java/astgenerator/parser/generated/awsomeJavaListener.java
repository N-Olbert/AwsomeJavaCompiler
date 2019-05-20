// Generated from C:/Users/david/IdeaProjects/AwsomeJavaCompiler/src/main/java/astgenerator/parser/grammar\awsomeJava.g4 by ANTLR 4.7.2
package astgenerator.parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link awsomeJavaParser}.
 */
public interface awsomeJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#programm}.
	 * @param ctx the parse tree
	 */
	void enterProgramm(awsomeJavaParser.ProgrammContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#programm}.
	 * @param ctx the parse tree
	 */
	void exitProgramm(awsomeJavaParser.ProgrammContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#jClass}.
	 * @param ctx the parse tree
	 */
	void enterJClass(awsomeJavaParser.JClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#jClass}.
	 * @param ctx the parse tree
	 */
	void exitJClass(awsomeJavaParser.JClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(awsomeJavaParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(awsomeJavaParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(awsomeJavaParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(awsomeJavaParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(awsomeJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(awsomeJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(awsomeJavaParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(awsomeJavaParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#methodParameter}.
	 * @param ctx the parse tree
	 */
	void enterMethodParameter(awsomeJavaParser.MethodParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#methodParameter}.
	 * @param ctx the parse tree
	 */
	void exitMethodParameter(awsomeJavaParser.MethodParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#nMethodParameters}.
	 * @param ctx the parse tree
	 */
	void enterNMethodParameters(awsomeJavaParser.NMethodParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#nMethodParameters}.
	 * @param ctx the parse tree
	 */
	void exitNMethodParameters(awsomeJavaParser.NMethodParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#nArguments}.
	 * @param ctx the parse tree
	 */
	void enterNArguments(awsomeJavaParser.NArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#nArguments}.
	 * @param ctx the parse tree
	 */
	void exitNArguments(awsomeJavaParser.NArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#instVar}.
	 * @param ctx the parse tree
	 */
	void enterInstVar(awsomeJavaParser.InstVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#instVar}.
	 * @param ctx the parse tree
	 */
	void exitInstVar(awsomeJavaParser.InstVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(awsomeJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(awsomeJavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#basicexpressions}.
	 * @param ctx the parse tree
	 */
	void enterBasicexpressions(awsomeJavaParser.BasicexpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#basicexpressions}.
	 * @param ctx the parse tree
	 */
	void exitBasicexpressions(awsomeJavaParser.BasicexpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#statementExpressions}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressions(awsomeJavaParser.StatementExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#statementExpressions}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressions(awsomeJavaParser.StatementExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#localVarDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDeclaration(awsomeJavaParser.LocalVarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#localVarDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDeclaration(awsomeJavaParser.LocalVarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(awsomeJavaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(awsomeJavaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#jNew}.
	 * @param ctx the parse tree
	 */
	void enterJNew(awsomeJavaParser.JNewContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#jNew}.
	 * @param ctx the parse tree
	 */
	void exitJNew(awsomeJavaParser.JNewContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(awsomeJavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(awsomeJavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(awsomeJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(awsomeJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(awsomeJavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(awsomeJavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#statementOrStatementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementOrStatementExpression(awsomeJavaParser.StatementOrStatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#statementOrStatementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementOrStatementExpression(awsomeJavaParser.StatementOrStatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void enterIfelse(awsomeJavaParser.IfelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void exitIfelse(awsomeJavaParser.IfelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#jWhile}.
	 * @param ctx the parse tree
	 */
	void enterJWhile(awsomeJavaParser.JWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#jWhile}.
	 * @param ctx the parse tree
	 */
	void exitJWhile(awsomeJavaParser.JWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#jReturn}.
	 * @param ctx the parse tree
	 */
	void enterJReturn(awsomeJavaParser.JReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#jReturn}.
	 * @param ctx the parse tree
	 */
	void exitJReturn(awsomeJavaParser.JReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(awsomeJavaParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(awsomeJavaParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#operatorBeforeExpr}.
	 * @param ctx the parse tree
	 */
	void enterOperatorBeforeExpr(awsomeJavaParser.OperatorBeforeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#operatorBeforeExpr}.
	 * @param ctx the parse tree
	 */
	void exitOperatorBeforeExpr(awsomeJavaParser.OperatorBeforeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#opBeforeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterOpBeforeIdentifier(awsomeJavaParser.OpBeforeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#opBeforeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitOpBeforeIdentifier(awsomeJavaParser.OpBeforeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#operatorAfterExpr}.
	 * @param ctx the parse tree
	 */
	void enterOperatorAfterExpr(awsomeJavaParser.OperatorAfterExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#operatorAfterExpr}.
	 * @param ctx the parse tree
	 */
	void exitOperatorAfterExpr(awsomeJavaParser.OperatorAfterExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#binary}.
	 * @param ctx the parse tree
	 */
	void enterBinary(awsomeJavaParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#binary}.
	 * @param ctx the parse tree
	 */
	void exitBinary(awsomeJavaParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#pointBinary}.
	 * @param ctx the parse tree
	 */
	void enterPointBinary(awsomeJavaParser.PointBinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#pointBinary}.
	 * @param ctx the parse tree
	 */
	void exitPointBinary(awsomeJavaParser.PointBinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(awsomeJavaParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(awsomeJavaParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link awsomeJavaParser#objectType}.
	 * @param ctx the parse tree
	 */
	void enterObjectType(awsomeJavaParser.ObjectTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link awsomeJavaParser#objectType}.
	 * @param ctx the parse tree
	 */
	void exitObjectType(awsomeJavaParser.ObjectTypeContext ctx);
}