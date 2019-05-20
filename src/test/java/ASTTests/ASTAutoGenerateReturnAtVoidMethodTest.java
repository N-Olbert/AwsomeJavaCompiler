package ASTTests;

import General.ResourceHelper;
import astgenerator.expressions.JNull;
import astgenerator.generalelements.Class;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.Block;
import astgenerator.statements.Return;
import astgenerator.statements.Statement;
import common.*;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ASTAutoGenerateReturnAtVoidMethodTest {
    @Test
    public void testVoidMethodWithNoReturn()
    {
        InputStream file = ResourceHelper.getFileAsStream("voidMethodWithoutReturn.java");
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        ASTGenerator astGen = factory.getASTGenerator();
        assertNotNull(astGen);

        String className = "TestVoidMethod";
        Class testClass = new Class(ObjectType.getType(className), new ArrayList<>(), new ArrayList<>());
        testClass.getMethods().add(new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE,
                ObjectType.VoidType, className, new ArrayList<MethodParameter>(), new Block(new Statement[0])));
        
        testClass.getMethods().add(new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE,
                ObjectType.VoidType, "testWithoutReturn",new ArrayList<>(), new Block(new Return())));
        UntypedProgram testProgram = new UntypedProgram();
        List<Class> classes = new ArrayList<Class>();
        classes.add(testClass);
        testProgram.setClasses(classes);

        UntypedProgram untypedProgram = astGen.getAST(file);
        var astClass = untypedProgram.getClasses().get(0);
        assertNotNull(untypedProgram);
        assertEquals(1, untypedProgram.getClasses().size());
        assertEquals(ObjectType.getType(className), astClass.getClassType());

        assertEquals(testClass.getFields().size(), astClass.getFields().size());
        assertEquals(testClass.getMethods().size(), astClass.getMethods().size());

        var ctor = astClass.getMethods().get(0);
        var ctorExpected = testClass.getMethods().get(0);
        assertEquals(ctorExpected.getAccessModifier(), ctor.getAccessModifier());
        assertEquals(ctorExpected.getModifier(), ctor.getModifier());
        assertEquals(ctorExpected.getName(), ctor.getName());
        assertEquals(ctorExpected.getParams().size(), ctor.getParams().size());
        assertEquals(ctorExpected.getStmt(), ctor.getStmt());
        assertEquals(ctorExpected.getReturnType(), ctor.getReturnType());

        var voidMethod = astClass.getMethods().get(1);
        var expectedVoidMethod = testClass.getMethods().get(1);

        assertEquals(expectedVoidMethod.getReturnType(), voidMethod.getReturnType());
        assertEquals(expectedVoidMethod.getStmt(), voidMethod.getStmt());
        assertEquals(expectedVoidMethod.getParams().size(), voidMethod.getParams().size());
        assertEquals(expectedVoidMethod.getName(), voidMethod.getName());
        assertEquals(expectedVoidMethod.getAccessModifier(), voidMethod.getAccessModifier());
        assertEquals(expectedVoidMethod.getModifier(), voidMethod.getModifier());

    }

}
