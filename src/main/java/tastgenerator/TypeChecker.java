package tastgenerator;

import astgenerator.expressions.*;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.*;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.*;
import tastgenerator.statements.*;

public interface TypeChecker
{
    TypedAssignExpression typeCheck(AssignExpression toCheck);
    TypedBinary typeCheck(Binary toCheck);
    TypedInstVar typeCheck(InstVar toCheck);
    TypedBoolean typeCheck(JBoolean toCheck);
    TypedChar typeCheck(JCharacter toCheck);
    TypedInt typeCheck(JInteger toCheck);
    TypedNull typeCheck(JNull toCheck);
    TypedLocalOrFieldVar typeCheck(LocalOrFieldVar toCheck);
    TypedMethodCallExpression typeCheck(MethodCallExpression toCheck);
    TypedNewExpression typeCheck(NewExpression toCheck);
    TypedSuper typeCheck(Super toCheck);
    TypedThis typeCheck(This toCheck);
    TypedUnary typeCheck(Unary toCheck);

    TypedClass typeCheck(Class toCheck);
    TypedFieldDeclaration typeCheck(FieldDeclaration toCheck);
    TypedMethodDeclaration typeCheck(MethodDeclaration toCheck);
    TypedMethodParameter typeCheck(MethodParameter toCheck);
    TypedProgram typeCheck(UntypedProgram toCheck);

    TypedAssignStatement typeCheck(AssignStatement toCheck);
    TypedBlock typeCheck(Block toCheck);
    TypedIfElse typeCheck(IfElse toCheck);
    TypedLocalVarDeclaration typeCheck(LocalVarDeclaration toCheck);
    TypedMethodCallStatement typeCheck(MethodCallStatement toCheck);
    TypedNewStatement typeCheck(NewStatement toCheck);
    TypedReturn typeCheck(Return toCheck);
    TypedWhile typeCheck(While toCheck);




}
