// Generated from C:/Users/david/IdeaProjects/AwsomeJavaCompiler/src/main/java/astgenerator/parser/grammar\awsomeJava.g4 by ANTLR 4.7.2
package astgenerator.parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link awsomeJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface awsomeJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#programm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramm(awsomeJavaParser.ProgrammContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#jClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJClass(awsomeJavaParser.JClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(awsomeJavaParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(awsomeJavaParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(awsomeJavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(awsomeJavaParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#methodParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodParameter(awsomeJavaParser.MethodParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#nMethodParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNMethodParameters(awsomeJavaParser.NMethodParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#nArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNArguments(awsomeJavaParser.NArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#instVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstVar(awsomeJavaParser.InstVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(awsomeJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#basicexpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicexpressions(awsomeJavaParser.BasicexpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#statementExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressions(awsomeJavaParser.StatementExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#localVarDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDeclaration(awsomeJavaParser.LocalVarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(awsomeJavaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#jNew}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJNew(awsomeJavaParser.JNewContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(awsomeJavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(awsomeJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(awsomeJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#statementOrStatementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementOrStatementExpression(awsomeJavaParser.StatementOrStatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#ifelse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelse(awsomeJavaParser.IfelseContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#jWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJWhile(awsomeJavaParser.JWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#jReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJReturn(awsomeJavaParser.JReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(awsomeJavaParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#operatorBeforeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorBeforeExpr(awsomeJavaParser.OperatorBeforeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#opBeforeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpBeforeIdentifier(awsomeJavaParser.OpBeforeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#operatorAfterExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorAfterExpr(awsomeJavaParser.OperatorAfterExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#binary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(awsomeJavaParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#binaryelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryelement(awsomeJavaParser.BinaryelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#pointBinary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointBinary(awsomeJavaParser.PointBinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(awsomeJavaParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link awsomeJavaParser#objectType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectType(awsomeJavaParser.ObjectTypeContext ctx);
}