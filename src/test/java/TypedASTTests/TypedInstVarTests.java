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
        testBasicInstVar(TypedTestClass1.BOOLVAR_NAME, ObjectType.BoolType.getName());
    }

    @Test
    public void testIntInstVar()
    {
        testBasicInstVar(TypedTestClass1.INTVAR_NAME, ObjectType.IntType.getName());
    }

    @Test
    public void testCharInstVar()
    {
        testBasicInstVar(TypedTestClass1.CHARVAR_NAME, ObjectType.CharType.getName());
    }

    @Test
    public void testOwnTypeInstVar()
    {
        testBasicInstVar(TypedTestClass1.OWNTYPEVAR_NAME, TypedTestClass1.OWNTYPE_NAME);
    }

    @Test(expected = Exception.class)
    public void testInstVarBasicFail1()
    {
        testBasicInstVar("nope", ObjectType.IntType.getName());
    }

    @Test(expected = Exception.class)
    public void testInstVarBasicFail2()
    {
        testBasicInstVar(TypedTestClass1.BOOLVAR_NAME, ObjectType.IntType.getName());
    }

    @Test(expected = Exception.class)
    public void testInstVarBasicFail3()
    {
        testBasicInstVar(TypedTestClass1.OWNTYPEVAR_NAME, ObjectType.JObjectType.getName());
    }

    private static void testBasicInstVar(String instVarName, String instVarType)
    {
        var program = TypedTestClass1.getBasicProgram();
        var method =
                new MethodDeclaration(ObjectType.VoidType, "a", new ArrayList<>(),
                                      new Block(
                                              new AssignStatement(
                                                      new InstVar(new This(), instVarName),
                                                      new NewExpression(ObjectType.getType(instVarType),
                                                                        new ArrayList<>()))));

        program.getClasses().get(0).getMethods().add(method);
        var converter = new TypeCheckerInstance(program);
        var converted = method.toTyped(converter);
        assertEquals(converted.getObjectType(), ObjectType.VoidType);
        var block = converted.getStmt();
        assertNotNull(block);
        var assign = (TypedAssignStatement)block.getBlockedStatements().get(0);
        assertEquals(assign.getObjectType(), ObjectType.VoidType);
        var localVar = (TypedInstVar)assign.getExpression1();
        assertEquals(localVar.getObjectType(), ObjectType.getType(instVarName));
    }


}
