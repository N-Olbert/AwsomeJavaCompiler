package tastgenerator;

import astgenerator.expressions.*;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statementexpressions.Assign;
import astgenerator.statementexpressions.MethodCall;
import astgenerator.statementexpressions.New;
import astgenerator.statements.*;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.*;
import tastgenerator.statementexpressions.TypedAssign;
import tastgenerator.statementexpressions.TypedMethodCall;
import tastgenerator.statementexpressions.TypedNew;
import tastgenerator.statements.*;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckerInstance implements TypeChecker
{

    @Override
    public TypedWhile typeCheck(While toCheck)
    {
        return null;
    }

    @Override
    public TypedReturn typeCheck(Return toCheck)
    {
        return null;
    }

    @Override
    public TypedStatemetExpressionStatement typeCheck(StatementExpressionStatement toCheck) {
        return null;
    }

    @Override
    public TypedBinary typeCheck(Binary toCheck)
    {
        return null;
    }

    @Override
    public TypedInstVar typeCheck(InstVar toCheck) {
        return null;
    }

    @Override
    public TypedBoolean typeCheck(JBoolean toCheck) {
        return null;
    }

    @Override
    public TypedChar typeCheck(JCharacter toCheck) {
        return null;
    }

    @Override
    public TypedInt typeCheck(JInteger toCheck) {
        return null;
    }

    @Override
    public TypedNull typeCheck(JNull toCheck) {
        return null;
    }

    @Override
    public TypedString typeCheck(JString toCheck) {
        return null;
    }

    @Override
    public TypedLocalOrFieldVar typeCheck(LocalOrFieldVar toCheck) {
        return null;
    }

    @Override
    public TypedStatementExpressionExpression typeCheck(StatementExpressionExpression toCheck) {
        return null;
    }

    @Override
    public TypedSuper typeCheck(Super toCheck) {
        return null;
    }

    @Override
    public TypedThis typeCheck(This toCheck) {
        return null;
    }

    @Override
    public TypedUnary typeCheck(Unary toCheck) {
        return null;
    }

    @Override
    public TypedClass typeCheck(Class toCheck) {
        List<TypedFieldDeclaration> typedFields = new ArrayList<>();
        for(FieldDeclaration field: toCheck.getFields()){
            typedFields.add((TypedFieldDeclaration) field.toTyped(this));
        }

        List<TypedMethodDeclaration> typedMethods = new ArrayList<>();
        for(MethodDeclaration method: toCheck.getMethods()){
            typedMethods.add((TypedMethodDeclaration) method.toTyped(this));
        }

        return new TypedClass(toCheck.getClassType(), typedFields, typedMethods);
    }

    @Override
    public TypedFieldDeclaration typeCheck(FieldDeclaration toCheck) {
        return null;
    }

    @Override
    public TypedMethodDeclaration typeCheck(MethodDeclaration toCheck) {
        return null;
    }

    @Override
    public TypedMethodParameter typeCheck(MethodParameter toCheck) {
        return null;
    }

    @Override
    public TypedProgram typeCheck(UntypedProgram toCheck) {
        return null;
    }

    @Override
    public TypedAssign typeCheck(Assign toCheck) {
        return null;
    }

    @Override
    public TypedMethodCall typeCheck(MethodCall toCheck) {
        return null;
    }

    @Override
    public TypedNew typeCheck(New toCheck) {
        return null;
    }

    @Override
    public TypedBlock typeCheck(Block toCheck) {
        return null;
    }

    @Override
    public TypedIfElse typeCheck(IfElse toCheck) {
        return null;
    }

    @Override
    public TypedLocalVarDeclaration typeCheck(LocalVarDeclaration toCheck) {
        return null;
    }
}
