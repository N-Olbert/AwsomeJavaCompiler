package TypedASTTests;

import astgenerator.expressions.*;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.Block;
import common.ObjectType;
import common.Operators;
import static org.junit.Assert.*;
import org.junit.Test;
import tastgenerator.TypeCheckerInstance;
import tastgenerator.expressions.TypedInstVar;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedAssignStatement;

import java.util.ArrayList;

public class TypedInstVarTests
{
    private static final String BOOLVAR_NAME = "x1";
    private static final String INTVAR_NAME = "x2";
    private static final String CHARVAR_NAME = "x3";
    private static final String OWNTYPE_NAME = "Test";
    private static final String OWNTYPEVAR_NAME = "x4";

    @Test
    public void testProgramBasicTyping()
    {
        var program = getBasicProgram();
        var converter = new TypeCheckerInstance(program);
        var typedProgram = converter.typeCheck(program);
        assertBasicProgram(typedProgram);
    }

    @Test
    public void testBoolInstVar()
    {
        testBasicInstVar(BOOLVAR_NAME, ObjectType.BoolType.getName());
    }

    @Test
    public void testIntInstVar()
    {
        testBasicInstVar(INTVAR_NAME, ObjectType.IntType.getName());
    }

    @Test
    public void testCharInstVar()
    {
        testBasicInstVar(CHARVAR_NAME, ObjectType.CharType.getName());
    }

    @Test
    public void testOwnTypeInstVar()
    {
        testBasicInstVar(OWNTYPEVAR_NAME, OWNTYPE_NAME);
    }

    @Test(expected = Exception.class)
    public void testInstVarBasicFail1()
    {
        testBasicInstVar("nope", ObjectType.IntType.getName());
    }

    @Test(expected = Exception.class)
    public void testInstVarBasicFail2()
    {
        testBasicInstVar(BOOLVAR_NAME, ObjectType.IntType.getName());
    }

    @Test(expected = Exception.class)
    public void testInstVarBasicFail3()
    {
        testBasicInstVar(OWNTYPEVAR_NAME, ObjectType.JObjectType.getName());
    }

    private static void testBasicInstVar(String instVarName, String instVarType)
    {
        var program = getBasicProgram();
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
        var localVar = (TypedInstVar)assign.getExpression();
        assertEquals(localVar.getObjectType(), ObjectType.getType(instVarName));
    }

    private static UntypedProgram getBasicProgram()
    {
        var fieldParams = new ArrayList<String[]>();
        fieldParams.add(new String[] { ObjectType.BoolType.getName(), BOOLVAR_NAME });
        fieldParams.add(new String[] { ObjectType.IntType.getName(), INTVAR_NAME });
        fieldParams.add(new String[] { ObjectType.CharType.getName(), CHARVAR_NAME });
        fieldParams.add(new String[] { ObjectType.getType(OWNTYPE_NAME).getName(), OWNTYPEVAR_NAME });
        var fields = UntypedProgramGenerator.getFields(fieldParams);
        return UntypedProgramGenerator.getProgram(OWNTYPE_NAME, fields, new ArrayList<>());
    }

    private static void assertBasicProgram(TypedProgram program)
    {
        assertNotNull(program);
        assertNotNull(program.getClasses());
        assertEquals(program.getClasses().size(), 1);
        var myclass = program.getClasses().get(0);
        assertNotNull(myclass);
        assertEquals(myclass.getClassType(), ObjectType.getType(OWNTYPE_NAME));
        assertNotNull(myclass.getFields());
        assertEquals(myclass.getFields().size(), 4);
        var field = myclass.getFields().stream().filter(x -> BOOLVAR_NAME.equals(x.getName())).findFirst().get();
        assertEquals(field.getObjectType(), ObjectType.BoolType);
        field = myclass.getFields().stream().filter(x -> INTVAR_NAME.equals(x.getName())).findFirst().get();
        assertEquals(field.getObjectType(), ObjectType.IntType);
        field = myclass.getFields().stream().filter(x -> CHARVAR_NAME.equals(x.getName())).findFirst().get();
        assertEquals(field.getObjectType(), ObjectType.CharType);
        field = myclass.getFields().stream().filter(x -> OWNTYPEVAR_NAME.equals(x.getName())).findFirst().get();
        assertEquals(field.getObjectType(), ObjectType.getType(OWNTYPE_NAME));
    }
}
