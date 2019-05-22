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
        var classGeneratedByAST = ast.getClasses().get(0);
        assertNotNull(ast);
        assertEquals(ast.getClasses().size(), 1);
        assertEquals(classGeneratedByAST.getClassType(), ObjectType.getType(className));

        assertEquals(testClass.getFields().size(), classGeneratedByAST.getFields().size() );
        assertEquals(testClass.getMethods().size(), classGeneratedByAST.getMethods().size());
        var ctorFromAST = classGeneratedByAST.getMethods().get(0);
        var expectedCtor = testClass.getMethods().get(0);
        assertEquals(expectedCtor.getAccessModifier(), ctorFromAST.getAccessModifier());
        assertEquals(expectedCtor.getModifier(), ctorFromAST.getModifier());
        assertEquals(expectedCtor.getReturnType(), ctorFromAST.getReturnType());
        assertEquals(expectedCtor.getParams().size(), ctorFromAST.getParams().size());
        assertEquals(expectedCtor.getName(), ctorFromAST.getName());
        assertTrue(ctorFromAST.getStmt() instanceof Block);
        assertEquals(
                ((Block)(ctorFromAST.getStmt())).getBlockedStatements().size(),
                ((Block)(testClass.getMethods().get(0).getStmt())).getBlockedStatements().size());

    }
}
