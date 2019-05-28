package BytecodeTests;

import General.BytecodeLoader;
import General.Fibonacci;
import common.Global;
import org.junit.Test;
import tastgenerator.generalelements.TypedProgram;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

public class FibonacciBytecodeTest {
    @Test
    public void testFibonacciRecursive() throws Exception {
        var program = Fibonacci.getTypedRecursiveFibonacciProgram();
        assertFibonacci(program);
    }

    @Test
    public void testFibonacciIterative() throws Exception {
        var program = Fibonacci.getTypedIterativeFibonacciProgram();
        assertFibonacci(program);
    }

    private void assertFibonacci(TypedProgram program) throws Exception {
        var byteCode = Global.getFactory().getBytecodeGenerator().generate(program);
        BytecodeTests.saveClass(byteCode.get(0).toByteArray(), "target/fibonacci.class");
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("Fibonacci");
        assertEquals(theClass.getDeclaredConstructors().length, 1);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance();
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith("Fibonacci@"));
        var method = theClass.getMethod("fibonacci", int.class);
        assertNotNull(method);
        var result = method.invoke(thing, 11);
        assertEquals(89, result);
    }
}
