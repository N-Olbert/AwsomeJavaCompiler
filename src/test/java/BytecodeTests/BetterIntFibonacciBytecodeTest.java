package BytecodeTests;

import General.BetterInt;
import General.BytecodeLoader;
import TypedASTTests.FibonacciTastGeneration;
import common.BytecodeGenerator;
import common.Factory;
import common.Global;
import org.junit.Test;
import org.objectweb.asm.ClassWriter;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.ibm.icu.impl.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BetterIntFibonacciBytecodeTest
{
    @Test
    public void FibonacciBetterIntBytecode()
    {
        var program = FibonacciTastGeneration.getFibonacciRecursiveWithBetterInt();
        program.getClasses().add(BetterInt.getTypedBetterIntClass());

        var factory = Global.getFactory();
        assertNotNull(factory);
        var byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        List<ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);

        assertEquals(cws.size(), 2);
        byte[] bytes = cws.get(0).toByteArray();
        byte[] bytes2 = cws.get(1).toByteArray();
        BytecodeTests.saveClass(bytes, "target/fibonacciBetterInt.class");
        BytecodeTests.saveClass(bytes2, "target/fibonacciBetterInt2.class");
        BytecodeLoader loader = new BytecodeLoader(bytes);
        BytecodeLoader betterIntLoader = new BytecodeLoader(bytes2);
        //var Class = loader.findClass("Fibonacci");
        var betterInt = betterIntLoader.findClass("BetterInt");
        //assertNotNull(Class);
        //assertNotNull(betterInt);
        Object classObject;
        Object betterIntObject;
        try {
            var betterIntConstructor = betterIntLoader.getConstructor("BetterInt", int.class);
            betterIntObject = betterIntConstructor.newInstance(11);
            var theClass = loader.findClass("Fibonacci");
            assertEquals(theClass.getDeclaredConstructors().length, 1);
            classObject = theClass.getDeclaredConstructors()[0].newInstance();
            var method = loader.getMethod("Fibonacci", "fibonacci", betterInt);
            assertEquals(int.class, method.getReturnType());
            assertEquals(89, method.invoke(classObject, betterIntObject));
        }
        catch(IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            fail("fibonacci" + " failed");
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
    }
}
