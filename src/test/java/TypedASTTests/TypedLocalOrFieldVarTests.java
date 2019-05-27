package TypedASTTests;

import astgenerator.expressions.*;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.Block;
import astgenerator.statements.LocalVarDeclaration;
import common.AccessModifier;
import common.Global;
import common.Modifier;
import common.ObjectType;
import org.junit.Test;
import tastgenerator.exceptions.AlreadyDefinedException;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.TypedClass;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedAssignStatement;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedLocalVarDeclaration;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TypedLocalOrFieldVarTests
{
    @Test
    public void TestBasicLocalVar()
    {
        var method =
                new MethodDeclaration(ObjectType.VoidType, "a", new ArrayList<>(),
                        new Block(
                                new LocalVarDeclaration(ObjectType.CharType, "c"),
                                new AssignStatement(new LocalOrFieldVar("c"), new JCharacter("c"))));
        var prog = UntypedProgramGenerator.getProgram("TEST", null, new ArrayList<>(){{add(method);}});
        var typedProg = Global.getFactory().getTypedAstGenerator().getTypedProgram(prog);
        var referenceMethod = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE,
                ObjectType.VoidType, "a", new ArrayList<>(),
                new TypedBlock(new ArrayList<>()
                {{
                       add(new TypedLocalVarDeclaration(ObjectType.CharType, "c"));
                       add(new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.CharType, "c"), new TypedChar("c")));
                }}, ObjectType.VoidType));
        var classes = new ArrayList<TypedClass>();
        classes.add(new TypedClass(ObjectType.getType("TEST"), new ArrayList<>(), new ArrayList<>(){{add(referenceMethod);}}));
        var referenceProgram = new TypedProgram(classes);
        assertEquals(typedProg, referenceProgram);
    }

    @Test(expected = AlreadyDefinedException.class)
    public void TestDuplicateLocalVarFail()
    {
        var method =
                new MethodDeclaration(ObjectType.VoidType, "a", new ArrayList<>(),
                        new Block(
                                new LocalVarDeclaration(ObjectType.CharType, "c"),
                                new AssignStatement(new LocalOrFieldVar("c"), new JCharacter("c")),
                                new LocalVarDeclaration(ObjectType.BoolType, "c")));
        var prog = UntypedProgramGenerator.getProgram("TEST", null, new ArrayList<>(){{add(method);}});
        Global.getFactory().getTypedAstGenerator().getTypedProgram(prog);
    }

    @Test
    public void TestMemberAndLocalVarSameNameOk()
    {
        var method =
                new MethodDeclaration(ObjectType.VoidType, "a", new ArrayList<>(),
                        new Block(
                                new LocalVarDeclaration(ObjectType.CharType, "c"),
                                new AssignStatement(new LocalOrFieldVar("c"), new JCharacter("c")),
                                new AssignStatement(new InstVar(new This(), "c"), new JBoolean("true"))));
        var fields = UntypedProgramGenerator.getFields(new ArrayList<>(){{add(new String[]{ObjectType.BoolType.getName(), "c"});}});
        var prog = UntypedProgramGenerator.getProgram("TEST", fields, new ArrayList<>(){{add(method);}});
        var typed =  Global.getFactory().getTypedAstGenerator().getTypedProgram(prog);
        var referenceMethod = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE,
                ObjectType.VoidType, "a", new ArrayList<>(),
                new TypedBlock(new ArrayList<>()
                {{
                    add(new TypedLocalVarDeclaration(ObjectType.CharType, "c"));
                    add(new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.CharType, "c"), new TypedChar("c")));
                    add(new TypedAssignStatement(new TypedInstVar(new TypedThis(ObjectType.getType("TEST")), "c", ObjectType.BoolType), new TypedBoolean("true")));
                }}, ObjectType.VoidType));
        var classes = new ArrayList<TypedClass>();
        classes.add(new TypedClass(ObjectType.getType("TEST"),
                    new ArrayList<>(){{add(new TypedFieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.BoolType, "c"));}},
                    new ArrayList<>(){{add(referenceMethod);}}));
        var referenceProgram = new TypedProgram(classes);
        assertEquals(typed, referenceProgram);
    }
}
