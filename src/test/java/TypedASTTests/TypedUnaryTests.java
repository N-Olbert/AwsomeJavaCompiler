package TypedASTTests;

import astgenerator.expressions.*;
import astgenerator.generalelements.UntypedProgram;
import common.ObjectType;
import common.Operators;
import org.junit.Test;
import tastgenerator.TypeCheckerInstance;
import tastgenerator.expressions.TypedUnary;

import static org.junit.Assert.*;

public class TypedUnaryTests
{
    @Test
    public void testNegativeInt()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var unary = new Unary(new JInteger("4"), Operators.MINUS);
        var typedUnary = (TypedUnary) unary.toTyped(converter);
        assertNotNull(typedUnary);
        assertEquals(typedUnary.getObjectType(), ObjectType.IntType);
    }

    @Test
    public void testPositiveInt()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var unary = new Unary(new JInteger("4"), Operators.PLUS);
        var typedUnary = (TypedUnary) unary.toTyped(converter);
        assertNotNull(typedUnary);
        assertEquals(typedUnary.getObjectType(), ObjectType.IntType);
    }

    @Test
    public void testNegativeCharIntTypeInferring()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var unary = new Unary(new JCharacter("a"), Operators.MINUS);
        var typedUnary = (TypedUnary) unary.toTyped(converter);
        assertNotNull(typedUnary);
        assertEquals(typedUnary.getObjectType(), ObjectType.IntType);
    }

    @Test
    public void testPositiveCharIntTypeInferring()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var unary = new Unary(new JCharacter("a"), Operators.PLUS);
        var typedUnary = (TypedUnary) unary.toTyped(converter);
        assertNotNull(typedUnary);
        assertEquals(typedUnary.getObjectType(), ObjectType.IntType);
    }

    @Test
    public void testBasicNegation()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var unary = new Unary(new JBoolean("true"), Operators.NEGATION);
        var typedUnary = (TypedUnary) unary.toTyped(converter);
        assertNotNull(typedUnary);
        assertEquals(typedUnary.getObjectType(), ObjectType.BoolType);
    }

    @Test(expected = Exception.class)
    public void testBasicFail1()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var unary = new Unary(new JInteger("6"), Operators.NEGATION);
        unary.toTyped(converter);
    }

    @Test(expected = Exception.class)
    public void testBasicFail2()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var unary = new Unary(new JNull(), Operators.MINUS);
        unary.toTyped(converter);
    }
}
