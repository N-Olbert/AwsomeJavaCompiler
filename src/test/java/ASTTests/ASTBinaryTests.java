package ASTTests;

import General.ResourceHelper;
import astgenerator.expressions.Binary;
import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.expressions.Unary;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.Block;
import astgenerator.statements.LocalVarDeclaration;
import astgenerator.statements.Statement;
import common.*;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class ASTBinaryTests {

    @Test
    public void TestBinary()
    {
        InputStream file = ResourceHelper.getFileAsStream("TestASTBinary.java");
        Factory fac = Global.getFactory();
        assertNotNull(fac);
        ASTGenerator astGen = fac.getASTGenerator();
        assertNotNull(astGen);

        String className = "TestASTBinary";
        Class expectedTestClass = new Class(ObjectType.getType(className), new ArrayList<>(), new ArrayList<>());
        expectedTestClass.getFields().add(new FieldDeclaration
                (AccessModifier.PACKAGE_PRIVATE,  Modifier.NONE,ObjectType.IntType, "a"));
        expectedTestClass.getFields().add(new FieldDeclaration
                (AccessModifier.PACKAGE_PRIVATE,  Modifier.NONE,ObjectType.IntType, "b"));
        expectedTestClass.getFields().add(new FieldDeclaration
                (AccessModifier.PACKAGE_PRIVATE,  Modifier.NONE,ObjectType.IntType, "c"));

        expectedTestClass.getMethods().add(new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE,
                ObjectType.VoidType, className, new ArrayList<>(), new Block(new Statement[0])));

        var intResult = new LocalVarDeclaration(ObjectType.IntType, "result");
        var methodParams = new ArrayList<MethodParameter>();
        var assignPunktVorStrich = new AssignStatement(
                new LocalOrFieldVar("result"),
                new Binary(
                        new LocalOrFieldVar("a"),
                        new Binary(new LocalOrFieldVar("b"), new LocalOrFieldVar("c"), Operators.MULTIPLICATION),
                        Operators.PLUS));
        var methodBody = new Block(intResult, assignPunktVorStrich);

        expectedTestClass.getMethods().add(new MethodDeclaration
                (AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "punktVorStrich", methodParams, methodBody));

        var assignPunktVorStrichMitKlammer = new AssignStatement(
                new LocalOrFieldVar("result"),
                new Binary(
                        new Binary(new LocalOrFieldVar("a"), new LocalOrFieldVar("b"), Operators.PLUS),
                        new LocalOrFieldVar("c"),
                        Operators.MULTIPLICATION
                )
        );

        methodBody = new Block(intResult, assignPunktVorStrichMitKlammer);
        expectedTestClass.getMethods().add(new MethodDeclaration(
                AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "StrichVorPunktMitKlammer",methodParams, methodBody)
        );

        var punktVorStrichMitGeteilt = new AssignStatement(
                new LocalOrFieldVar("result"),
                new Binary(
                        new LocalOrFieldVar("a"),
                        new Binary(new LocalOrFieldVar("b"), new LocalOrFieldVar("c"), Operators.DIVISION),
                        Operators.PLUS)
        );
        methodBody = new Block(intResult, punktVorStrichMitGeteilt);
        expectedTestClass.getMethods().add(new MethodDeclaration(
                AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "punktVorStrichMitGeteilt", methodParams, methodBody
        ));

        var boolResult = new LocalVarDeclaration(ObjectType.BoolType, "result");
        var andVorOr = new AssignStatement(
                new LocalOrFieldVar("result"),
                new Binary(
                        new LocalOrFieldVar("a"),
                        new Binary(
                                new LocalOrFieldVar("b"),
                                new LocalOrFieldVar("c"),
                                Operators.AND
                ), Operators.OR)
        );

        methodBody = new Block(boolResult, andVorOr);
        expectedTestClass.getMethods().add(new MethodDeclaration(
                AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "andVorOr", methodParams, methodBody
        ));

        var binaryTest = new AssignStatement(
                new LocalOrFieldVar("result"),
                new Binary(
                        new Binary(
                                new LocalOrFieldVar("a"),
                                new LocalOrFieldVar("b"),
                                Operators.EQUALS
                        ),
                        new Unary(new LocalOrFieldVar("c"), Operators.NEGATION),
                        Operators.AND
                )
        );

        methodBody = new Block(boolResult, binaryTest);
        expectedTestClass.getMethods().add(new MethodDeclaration(
                AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "binaryTest", methodParams , methodBody)
        );

        var fancyShit = new AssignStatement(
                new LocalOrFieldVar("result"),
                new Binary(
                        new Binary(
                                new LocalOrFieldVar("a"),
                                new LocalOrFieldVar("b"),
                                Operators.MODULO
                        ),
                        new Binary(
                                new LocalOrFieldVar("b"),
                                new Binary(
                                        new LocalOrFieldVar("c"),
                                        new LocalOrFieldVar("a"),
                                        Operators.AND
                                ),
                                Operators.MULTIPLICATION
                        ),
                        Operators.PLUS
                )
        );

        methodBody = new Block(intResult, fancyShit);
        expectedTestClass.getMethods().add(new MethodDeclaration(
                AccessModifier.PUBLIC,
                Modifier.NONE,
                ObjectType.VoidType,
                "fancyShit",
                methodParams,
                methodBody
        ));

        UntypedProgram testProgram = new UntypedProgram();
        List<Class> classes = new ArrayList<>();
        classes.add(expectedTestClass);
        testProgram.setClasses(classes);

        UntypedProgram generatedTestProgram = astGen.getAST(file);
        assertEquals(testProgram, generatedTestProgram);
    }
}
