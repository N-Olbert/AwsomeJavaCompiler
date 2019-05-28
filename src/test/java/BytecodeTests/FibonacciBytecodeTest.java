package BytecodeTests;

import General.BytecodeLoader;
import TypedASTTests.FibonacciTastGeneration;
import common.AccessModifier;
import common.Global;
import common.Modifier;
import common.ObjectType;
import common.Operators;
import org.junit.Test;
import tastgenerator.expressions.TypedBinary;
import tastgenerator.expressions.TypedInt;
import tastgenerator.expressions.TypedLocalOrFieldVar;
import tastgenerator.expressions.TypedMethodCallExpression;
import tastgenerator.expressions.TypedThis;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedAssignStatement;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedIfElse;
import tastgenerator.statements.TypedLocalVarDeclaration;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedStatement;
import tastgenerator.statements.TypedWhile;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FibonacciBytecodeTest {
    @Test
    public void testFibonacciRecursive() throws Exception {
        var program = FibonacciTastGeneration.getFibonacciTastRecursion();
        assertFibonacci(program);
    }

    @Test
    public void testFibonacciIterative() throws Exception {
        var program = FibonacciTastGeneration.getFibonacciTastIterative();
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
