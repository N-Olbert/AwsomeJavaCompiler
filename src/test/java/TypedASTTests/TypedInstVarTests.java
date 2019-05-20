package TypedASTTests;

import astgenerator.expressions.*;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.Block;
import common.ObjectType;

import static org.junit.Assert.*;
import org.junit.Test;
import tastgenerator.TypeCheckerInstance;
import tastgenerator.expressions.TypedInstVar;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedAssignStatement;

import java.util.ArrayList;

public class TypedInstVarTests
{
    @Test
    public void testProgramBasicTyping()
    {
        var program = TypedTestClass1.getBasicProgram();
        var converter = new TypeCheckerInstance(program);
        var typedProgram = converter.typeCheck(program);
        TypedTestClass1.assertBasicProgram(typedProgram);
    }

    @Test
    public void testBoolInstVar()
    {
        testBasicInstVar(TypedTestClass1.BOOLVAR_NAME, new JBoolean("true"), ObjectType.BoolType);
    }

    @Test
    public void testIntInstVar()
    {
        testBasicInstVar(TypedTestClass1.INTVAR_NAME, new JInteger("9"), ObjectType.IntType);
    }

    @Test
    public void testCharInstVar()
    {
        testBasicInstVar(TypedTestClass1.CHARVAR_NAME, new JCharacter("c"), ObjectType.CharType);
    }

    @Test
    public void testOwnTypeInstVar()
    {
        testBasicInstVar(TypedTestClass1.OWNTYPEVAR_NAME,
                new NewExpression(ObjectType.getType(TypedTestClass1.OWNTYPE_NAME), new ArrayList<>()),
                ObjectType.getType(TypedTestClass1.OWNTYPE_NAME));
    }

    @Test(expected = Exception.class)
    public void testInstVarBasicFail1()
    {
        testBasicInstVar("nope", new JInteger("1"), ObjectType.IntType);
    }

    @Test(expected = Exception.class)
    public void testInstVarBasicFail2()
    {
        testBasicInstVar(TypedTestClass1.BOOLVAR_NAME, new JInteger("1"), ObjectType.BoolType);
    }

    @Test(expected = Exception.class)
    public void testInstVarBasicFail3()
    {
        testBasicInstVar(TypedTestClass1.OWNTYPEVAR_NAME, new JInteger("1"), ObjectType.IntType);
    }

    private static void testBasicInstVar(String instVarName, Expression assignExpression, ObjectType expected)
    {
        var program = TypedTestClass1.getBasicProgram();
        var method =
                new MethodDeclaration(ObjectType.VoidType, "a", new ArrayList<>(),
                                      new Block(
                                              new AssignStatement(
                                                      new InstVar(new This(), instVarName),
                                                      assignExpression)));

        program.getClasses().get(0).getMethods().add(method);
        var converter = new TypeCheckerInstance(program);
        var convertedClass = (TypedProgram)program.toTyped(converter);
        var converted = convertedClass.getClasses().get(0).getMethods().get(0);
        assertEquals(converted.getObjectType(), ObjectType.VoidType);
        var block = converted.getStmt();
        assertNotNull(block);
        var assign = (TypedAssignStatement)block.getBlockedStatements().get(0);
        assertEquals(assign.getObjectType(), ObjectType.VoidType);
        var localVar = (TypedInstVar)assign.getExpression1();
        assertEquals(localVar.getObjectType(), expected);
    }


}
