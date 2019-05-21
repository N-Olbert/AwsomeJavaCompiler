package ASTTests;

import General.ResourceHelper;
import astgenerator.generalelements.Class;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.Block;
import astgenerator.statements.Statement;
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
        Class testClass = new Class(ObjectType.getType(className), new ArrayList<>(), new ArrayList<>());
        testClass.getMethods().add(new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType, className, new ArrayList<MethodParameter>(), new Block(new Statement[0])));
        UntypedProgram testProgram = new UntypedProgram();
        List<Class> classes = new ArrayList<Class>();
        classes.add(testClass);
        testProgram.setClasses(classes);


        UntypedProgram ast = astGen.getAST(file);
        var untypedTestClass = ast.getClasses().get(0);
        assertNotNull(ast);
        assertEquals(ast.getClasses().size(), 1);
        assertEquals(untypedTestClass.getClassType(), ObjectType.getType(className));

        assertEquals(testClass.getFields().size(), untypedTestClass.getFields().size() );
        assertEquals(testClass.getMethods().size(), untypedTestClass.getMethods().size());
        var method = untypedTestClass.getMethods().get(0);
        assertEquals(method.getAccessModifier(), AccessModifier.PACKAGE_PRIVATE);
        assertEquals(method.getModifier(), Modifier.NONE);
        assertEquals(method.getReturnType(), ObjectType.VoidType);
        assertEquals(method.getParams().size(), 0);
        assertEquals(method.getName(), className);
        assertTrue(method.getStmt() instanceof Block);
        assertEquals(((Block)(method.getStmt())).getBlockedStatements().size(), ((Block)(testClass.getMethods().get(0).getStmt())).getBlockedStatements().size());

    }
}
