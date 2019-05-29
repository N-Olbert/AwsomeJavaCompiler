package ASTTests;

import General.ResourceHelper;
import astgenerator.expressions.*;
import astgenerator.generalelements.Class;
import astgenerator.generalelements.FieldDeclaration;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.statements.*;
import common.*;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;

public class ASTElseIfTest {

    @Test
    public void TestElseIf()
    {
        InputStream file = ResourceHelper.getFileAsStream("TestMethodIfElseIf.java");
        Factory fac = Global.getFactory();
        assertNotNull(fac);
        ASTGenerator astGen = fac.getASTGenerator();
        assertNotNull(astGen);

        String className = "TestwithIfElseIf";
        Class expectedTestClass = new Class(ObjectType.getType(className), new ArrayList<>(), new ArrayList<>());
        expectedTestClass.getMethods().add(new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE,
                ObjectType.VoidType, className, new ArrayList<>(), new Block(new Statement[0])
        ));
        var param = new ArrayList<MethodParameter>();
        param.add(new MethodParameter(ObjectType.IntType, "x"));
        param.add(new MethodParameter(ObjectType.IntType, "y"));

        var block  =
                new Block(
                new LocalVarDeclaration(ObjectType.IntType, "t"),
                new AssignStatement(new LocalOrFieldVar("t"), new JInteger("-1")),
                new IfElse( new Binary(new LocalOrFieldVar("x"), new LocalOrFieldVar("y"), Operators.GREATERTHAN),
                            new Block(
                                    new AssignStatement(new LocalOrFieldVar("t"), new LocalOrFieldVar("x"))),
                            new Block(new IfElse(
                                            new Binary(new LocalOrFieldVar("x"),
                                            new LocalOrFieldVar("y"),
                                            Operators.EQUALS),
                                            new Block(new Return(new LocalOrFieldVar("y"))),
                                            new Block(new Return(new LocalOrFieldVar("t")))))

                )
        );

        expectedTestClass.getMethods().add(
                new MethodDeclaration
                        (AccessModifier.PACKAGE_PRIVATE, Modifier.NONE,
                                ObjectType.IntType, "TestIfElseIf", param, block

        ));
    }
}
