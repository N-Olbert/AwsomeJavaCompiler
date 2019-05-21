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
        InputStream file = ResourceHelper.getFileAsStream("TestCommentsareIgnored.java");
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        ASTGenerator astGen = factory.getASTGenerator();
        assertNotNull(astGen);

        String className = "TestComment";
        Class expectedClass = new Class(ObjectType.getType(className), new ArrayList<FieldDeclaration>(), new ArrayList<MethodDeclaration>());
        expectedClass.getMethods().add(new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType, className, new ArrayList<MethodParameter>(), new Block()));
        expectedClass.getFields().add(new FieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType, "tralala"));
        expectedClass.getFields().add(new FieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType, "dassollgesehenwerden"));
        expectedClass.getFields().add(new FieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.CharType, "genauwiedas"));

        UntypedProgram testProgram = new UntypedProgram();
        List<Class> classes = new ArrayList<Class>();
        classes.add(expectedClass);
        testProgram.setClasses(classes);

        UntypedProgram ast = astGen.getAST(file);
        var classGeneratedByAST = ast.getClasses().get(0);
        assertNotNull(ast);
        assertEquals(ast.getClasses().size(), testProgram.getClasses().size());
        assertEquals(ObjectType.getType(className), classGeneratedByAST.getClassType());
        assertEquals(expectedClass.getFields().size(), classGeneratedByAST.getFields().size());
        assertEquals(expectedClass.getMethods().size(), classGeneratedByAST.getMethods().size());

        var generatedCtor = classGeneratedByAST.getMethods().get(0);
        var expectedCtor = expectedClass.getMethods().get(0);
        assertEquals(expectedCtor.getAccessModifier(), generatedCtor.getAccessModifier() );
        assertEquals(expectedCtor.getModifier(), generatedCtor.getModifier());
        assertEquals(expectedCtor.getReturnType(), generatedCtor.getReturnType());
        assertEquals(expectedCtor.getParams().size(), generatedCtor.getParams().size());
        assertEquals(expectedCtor.getName(), generatedCtor.getName());
        assertTrue(generatedCtor.getStmt() instanceof Block);

        var field1Expected = expectedClass.getFields().get(0);
        var field1AST = classGeneratedByAST.getFields().get(0);

        assertEquals(field1Expected.getVariableType(), field1AST.getVariableType());
        assertEquals(field1Expected.getName(), field1AST.getName());
        assertEquals(field1Expected.getModifier(), field1AST.getModifier());
        assertEquals(field1Expected.getAccessModifier(), field1AST.getAccessModifier());

        var field2Expected = expectedClass.getFields().get(1);
        var field2AST = classGeneratedByAST.getFields().get(1);

        assertEquals(field2Expected.getAccessModifier(), field2AST.getAccessModifier());
        assertEquals(field2Expected.getModifier(), field2AST.getModifier());
        assertEquals(field2Expected.getName(), field2AST.getName());
        assertEquals(field2Expected.getVariableType(), field2AST.getVariableType());

        var field3Expected = expectedClass.getFields().get(2);
        var field3AST = expectedClass.getFields().get(2);

        assertEquals(field3Expected.getAccessModifier(), field3AST.getAccessModifier());
        assertEquals(field3Expected.getModifier(), field3AST.getModifier());
        assertEquals(field3Expected.getVariableType(), field3AST.getVariableType());
        assertEquals(field3Expected.getName(), field3AST.getName());
    }
}
