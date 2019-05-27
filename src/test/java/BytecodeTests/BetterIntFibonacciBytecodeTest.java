package BytecodeTests;

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

        var factory = Global.getFactory();
        assertNotNull(factory);
        var byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        List<ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);

        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeTests.saveClass(bytes, "target/fibonacciBetterInt.class");
        BytecodeLoader loader = new BytecodeLoader(bytes);
        var Class = loader.findClass("Fibonacci");
        assertNotNull(Class);
        Object classObject;
        try {
            var constructor = loader.getConstructor("Fibonacci");
            classObject = constructor.newInstance();
            var method = loader.getMethod("Fibonacci", "fibonacci");
            assertEquals(int.class, method.getReturnType());
            assertEquals(3, method.invoke(classObject/* ToDo BetterInt übergeben */));
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
