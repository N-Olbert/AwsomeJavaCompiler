package TypedASTTests;

import astgenerator.expressions.*;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.Block;
import astgenerator.statements.LocalVarDeclaration;
import common.ObjectType;
import common.Operators;
import static org.junit.Assert.*;

import org.junit.Test;
import tastgenerator.TypeCheckerInstance;
import tastgenerator.expressions.TypedBinary;

public class TypedBinaryTests
{
    @Test
    public void testBasicInt()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JInteger("5"), new JInteger("2"), Operators.MINUS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getOperator(), Operators.MINUS);
    }

    @Test
    public void testCharInferringInt()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JCharacter("a"), new JCharacter("b"), Operators.MINUS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getOperator(), Operators.MINUS);
    }

    @Test
    public void testMixedPrimitiveInferringTypes1()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JCharacter("a"), new JInteger("3"), Operators.MINUS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getOperator(), Operators.MINUS);
    }

    @Test
    public void testMixedPrimitiveInferringTypes2()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JInteger("3"), new JCharacter("a"), Operators.MINUS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getOperator(), Operators.MINUS);
    }

    @Test(expected = Exception.class)
    public void testBasicFail()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JInteger("3"), new JNull(), Operators.MINUS);
        binary.toTyped(converter);
    }

    @Test(expected = Exception.class)
    public void testBasicFail2()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JInteger("3"), new This(), Operators.MINUS);
        binary.toTyped(converter);
    }

    @Test(expected = Exception.class)
    public void testBasicFail3()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JInteger("3"), new InstVar(new This(), "notExisiting"), Operators.MINUS);
        binary.toTyped(converter);
    }

    @Test(expected = Exception.class)
    public void testIntCharInferenceFails1()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var block = new Block();
        var localVarDecl = new LocalVarDeclaration(ObjectType.CharType, "i");
        var assign = new AssignStatement(new LocalOrFieldVar("i"),
                                new Binary(new JInteger("3"), new JInteger("3"), Operators.MINUS));
        block.getBlockedStatements().add(localVarDecl);
        block.getBlockedStatements().add(assign);
        block.toTyped(converter);
    }

    @Test(expected = Exception.class)
    public void testIntCharInferenceFails2()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var block = new Block();
        var localVarDecl = new LocalVarDeclaration(ObjectType.CharType, "i");
        var assign = new AssignStatement(new LocalOrFieldVar("i"),
                                new Binary(new JCharacter("a"), new JCharacter("b"), Operators.MINUS));
        block.getBlockedStatements().add(localVarDecl);
        block.getBlockedStatements().add(assign);
        block.toTyped(converter);
    }

    @Test(expected = Exception.class)
    public void testIntCharInferenceFails3()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var block = new Block();
        var localVarDecl = new LocalVarDeclaration(ObjectType.CharType, "i");
        var assign = new AssignStatement(new LocalOrFieldVar("i"),
                                new Binary(new JInteger("3"), new JCharacter("a"), Operators.MINUS));
        block.getBlockedStatements().add(localVarDecl);
        block.getBlockedStatements().add(assign);
        block.toTyped(converter);
    }

    @Test(expected = Exception.class)
    public void testIntCharInferenceFails4()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var block = new Block();
        var localVarDecl = new LocalVarDeclaration(ObjectType.CharType, "i");
        var assign = new AssignStatement(new LocalOrFieldVar("i"),
                                new Binary(new JCharacter("a"), new JInteger("3"), Operators.MINUS));
        block.getBlockedStatements().add(localVarDecl);
        block.getBlockedStatements().add(assign);
        block.toTyped(converter);
    }

    @Test
    public void testIntEqualsInferringBool1()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JInteger("1"), new JInteger("1"), Operators.EQUALS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.BoolType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getOperator(), Operators.EQUALS);
    }

    @Test
    public void testIntEqualsInferringBool2()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JInteger("1"), new JInteger("1"), Operators.NOTEQUALS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.BoolType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getOperator(), Operators.NOTEQUALS);
    }

    @Test
    public void testCharEqualsInferringBool1()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JCharacter("1"), new JCharacter("1"), Operators.EQUALS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.BoolType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getOperator(), Operators.EQUALS);
    }

    @Test
    public void testCharEqualsInferringBool2()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JCharacter("1"), new JCharacter("1"), Operators.NOTEQUALS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.BoolType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getOperator(), Operators.NOTEQUALS);
    }

    @Test
    public void testCharIntEqualsInferringBool1()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JCharacter("1"), new JInteger("1"), Operators.EQUALS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.BoolType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getOperator(), Operators.EQUALS);
    }

    @Test
    public void testCharIntEqualsInferringBool2()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JCharacter("1"), new JInteger("1"), Operators.NOTEQUALS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.BoolType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getOperator(), Operators.NOTEQUALS);
    }

    @Test
    public void testCharIntEqualsInferringBool3()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JInteger("1"), new JCharacter("1"), Operators.EQUALS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.BoolType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getOperator(), Operators.EQUALS);
    }

    @Test
    public void testCharIntEqualsInferringBool4()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var binary = new Binary(new JInteger("1"), new JCharacter("1"), Operators.NOTEQUALS);
        var typedBinary = (TypedBinary)binary.toTyped(converter);
        assertNotNull(typedBinary);
        assertEquals(typedBinary.getObjectType(), ObjectType.BoolType);
        assertEquals(typedBinary.getExpression().getObjectType(), ObjectType.IntType);
        assertEquals(typedBinary.getExpression2().getObjectType(), ObjectType.CharType);
        assertEquals(typedBinary.getOperator(), Operators.NOTEQUALS);
    }
}
