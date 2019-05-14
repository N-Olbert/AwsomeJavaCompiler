package ASTTests;

import General.ResourceHelper;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.Block;
import common.*;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class ASTClassCommentsIgnoredTest {

    @Test
    public void testASTCommentsIgnored()
    {
        //Generate AST from BasisClass.java
        InputStream file = ResourceHelper.getFileAsStream("TestCommentsareIgnored.java");
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        ASTGenerator astGen = factory.getASTGenerator();
        assertNotNull(astGen);

        //Create expected Program
        String className = "TestComment";
        Class testClass = new Class(ObjectType.getType(className), new ArrayList<FieldDeclaration>(), new ArrayList<MethodDeclaration>());
        testClass.getMethods().add(new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType, className, new ArrayList<MethodParameter>(), new Block(null)));
        testClass.getFields().add(new FieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType, "tralala"));
        testClass.getFields().add(new FieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType, "dassollgesehenwerden"));
        testClass.getFields().add(new FieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.CharType, "genauwiedas"));

        UntypedProgram testProgram = new UntypedProgram();
        List<Class> classes = new ArrayList<Class>();
        classes.add(testClass);
        testProgram.setClasses(classes);

        UntypedProgram ast = astGen.getAST(file);
        var untypedTestClass = ast.getClasses().get(0);
        assertNotNull(ast);
        assertEquals(ast.getClasses().size(), testProgram.getClasses().size());
        assertEquals(untypedTestClass.getClassType(), ObjectType.getType(className));
        assertEquals(untypedTestClass.getFields().size(), testClass.getFields().size());
        assertEquals(untypedTestClass.getMethods().size(), testClass.getMethods().size());

        var method = untypedTestClass.getMethods().get(0);
        var constructorTest = testClass.getMethods().get(0);
        assertEquals(method.getAccessModifier(), constructorTest.getAccessModifier());
        assertEquals(method.getModifier(), constructorTest.getModifier());
        assertEquals(method.getReturnType(), constructorTest.getReturnType());
        assertEquals(method.getParams().size(), constructorTest.getParams().size());
        assertEquals(method.getName(), constructorTest.getName());
        assertTrue(method.getStmt() instanceof Block);
        assertNull(((Block)(method.getStmt())).getBlockedStatements());

        var field1 = untypedTestClass.getFields().get(0);
        var fieldTest1 = testClass.getFields().get(0);

        assertEquals(field1.getVariableType(), fieldTest1.getVariableType());
        assertEquals(field1.getName(), fieldTest1.getName());
        assertEquals(field1.getModifier(), fieldTest1.getModifier());
        assertEquals(field1.getAccessModifier(), fieldTest1.getAccessModifier());

        var field2 = untypedTestClass.getFields().get(1);
        var fieldTest2 = testClass.getFields().get(1);

        assertEquals(field2.getAccessModifier(), fieldTest2.getAccessModifier());
        assertEquals(field2.getModifier(), fieldTest2.getModifier());
        assertEquals(field2.getName(), fieldTest2.getName());
        assertEquals(field2.getVariableType(), fieldTest2.getVariableType());

        var field3 = untypedTestClass.getFields().get(2);
        var fieldTest3 = testClass.getFields().get(2);

        assertEquals(field3.getAccessModifier(), fieldTest3.getAccessModifier());
        assertEquals(field3.getModifier(), fieldTest3.getModifier());
        assertEquals(field3.getVariableType(), fieldTest3.getVariableType());
        assertEquals(field3.getName(), fieldTest3.getName());
    }
}
