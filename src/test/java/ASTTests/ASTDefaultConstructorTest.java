package ASTTests;

import General.ResourceHelper;
import astgenerator.generalelements.Class;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.Block;
import common.*;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class ASTDefaultConstructorTest {

    @Test
    public void testASTGeneration()
    {
        InputStream file = ResourceHelper.getFileAsStream("BasicClassWithNoCtor.java");
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        ASTGenerator astGen = factory.getASTGenerator();
        assertNotNull(astGen);

        String className = "Test";
        Class testClass = new Class(ObjectType.getType(className), null, new ArrayList<MethodDeclaration>());
        testClass.getMethods().add(new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType, className, new ArrayList<MethodParameter>(), new Block(null)));
        UntypedProgram testProgram = new UntypedProgram();
        List<Class> classes = new ArrayList<Class>();
        classes.add(testClass);
        testProgram.setClasses(classes);


        UntypedProgram ast = astGen.getAST(file);
        var untypedTestClass = ast.getClasses().get(0);
        assertNotNull(ast);
        assertEquals(ast.getClasses().size(), 1);
        assertEquals(untypedTestClass.getClassType(), ObjectType.getType(className));

        assertEquals(untypedTestClass.getFields().size(), 0);
        assertEquals(untypedTestClass.getMethods().size(), 1);
        var method = untypedTestClass.getMethods().get(0);
        assertEquals(method.getAccessModifier(), AccessModifier.PACKAGE_PRIVATE);
        assertEquals(method.getModifier(), Modifier.NONE);
        assertEquals(method.getReturnType(), ObjectType.VoidType);
        assertEquals(method.getParams().size(), 0);
        assertEquals(method.getName(), className);
        assertTrue(method.getStmt() instanceof Block);
        assertTrue(((Block)(method.getStmt())).getBlockedStatements() == null);
    }
}