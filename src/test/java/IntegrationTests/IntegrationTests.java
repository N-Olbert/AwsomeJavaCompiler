package IntegrationTests;

import General.BytecodeLoader;
import General.ResourceHelper;
import common.Global;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class IntegrationTests
{
    @Test
    public void testBasicClass() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        var file = ResourceHelper.getFileAsStream("BasicClass.java");
        var ast = Global.getFactory().getASTGenerator().getAST(file);
        var typedAst = Global.getFactory().getTypedAstGenerator().getTypedProgram(ast);
        var byteCode = Global.getFactory().getBytecodeGenerator().generate(typedAst);
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("Test");
        assertEquals(theClass.getDeclaredConstructors().length, 1);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance(null);
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith("Test@"));
    }

    @Test
    public void testBasicClassWithoutCtor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        var file = ResourceHelper.getFileAsStream("BasicClassWithNoCtor.java");
        var ast = Global.getFactory().getASTGenerator().getAST(file);
        var typedAst = Global.getFactory().getTypedAstGenerator().getTypedProgram(ast);
        var byteCode = Global.getFactory().getBytecodeGenerator().generate(typedAst);
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("Test");
        assertEquals(theClass.getDeclaredConstructors().length, 1);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance(null);
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith("Test@"));
    }

    @Test
    public void testBetterInt() throws IllegalAccessException, InvocationTargetException, InstantiationException
    {
        var file = ResourceHelper.getFileAsStream("BetterInt.java");
        var ast = Global.getFactory().getASTGenerator().getAST(file);
        var typedAst = Global.getFactory().getTypedAstGenerator().getTypedProgram(ast);
        var byteCode = Global.getFactory().getBytecodeGenerator().generate(typedAst);
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("BetterInt");
        assertEquals(theClass.getDeclaredConstructors().length, 2);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance(5);
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith("BetterInt@"));
    }

    @Test
    public void testFibonacciRecursive() throws Exception
    {
        var file = ResourceHelper.getFileAsStream("Fibonacci.java");
        assertFibonacci(file);
    }

    public void testFibonacciIterative() throws Exception
    {
        var file = ResourceHelper.getFileAsStream("Fibonacci_Iter.java");
        assertFibonacci(file);
    }

    private void assertFibonacci(InputStream file) throws Exception
    {
        var ast = Global.getFactory().getASTGenerator().getAST(file);
        var typedAst = Global.getFactory().getTypedAstGenerator().getTypedProgram(ast);
        var byteCode = Global.getFactory().getBytecodeGenerator().generate(typedAst);
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("Fibonacci");
        assertEquals(theClass.getDeclaredConstructors().length, 1);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance(null);
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith("Fibonacci@"));
        var method = theClass.getMethod("fibonacci", int.class);
        assertNotNull(method);
        var result = method.invoke(thing,11);
        assertEquals(89, result);
    }
}
