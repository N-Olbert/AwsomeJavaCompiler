package tastgenerator;

import astgenerator.expressions.*;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statementexpressions.Assign;
import astgenerator.statementexpressions.MethodCall;
import astgenerator.statementexpressions.New;
import astgenerator.statementexpressions.StatementExpression;
import astgenerator.statements.*;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.*;
import tastgenerator.statementexpressions.TypedAssign;
import tastgenerator.statementexpressions.TypedMethodCall;
import tastgenerator.statementexpressions.TypedNew;
import tastgenerator.statements.*;

public interface TypeChecker
{
    TypedBinary typeCheck(Binary toCheck);
    TypedInstVar typeCheck(InstVar toCheck);
    TypedBoolean typeCheck(JBoolean toCheck);
    TypedChar typeCheck(JCharacter toCheck);
    TypedInt typeCheck(JInteger toCheck);
    TypedNull typeCheck(JNull toCheck);
    TypedString typeCheck(JString toCheck);
    TypedLocalOrFieldVar typeCheck(LocalOrFieldVar toCheck);
    TypedStatementExpressionExpression typeCheck(StatementExpressionExpression toCheck);
    TypedSuper typeCheck(Super toCheck);
    TypedThis typeCheck(This toCheck);
    TypedThisWrapper typeCheck(ThisWrapper toCheck);
    TypedUnary typeCheck(Unary toCheck);

    TypedClass typeCheck(Class toCheck);
    TypedFieldDeclaration typeCheck(FieldDeclaration toCheck);
    TypedMethodDeclaration typeCheck(MethodDeclaration toCheck);
    TypedMethodParameter typeCheck(MethodParameter toCheck);
    TypedProgram typeCheck(UntypedProgram toCheck);

    TypedAssign typeCheck(Assign toCheck);
    TypedMethodCall typeCheck(MethodCall toCheck);
    TypedNew typeCheck(New toCheck);

    TypedBlock typeCheck(Block toCheck);
    TypedIfElse typeCheck(IfElse toCheck);
    TypedLocalVarDeclaration typeCheck(LocalVarDeclaration toCheck);
    TypedReturn typeCheck(Return toCheck);
    TypedStatemetExpressionStatement typeCheck(StatementExpressionStatement toCheck);
    TypedWhile typeCheck(While toCheck);




}
