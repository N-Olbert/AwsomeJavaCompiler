package BytecodeTests;

import General.BetterInt;
import General.BytecodeLoader;
import TypedASTTests.FibonacciTastGeneration;
import common.Global;
import org.junit.Test;
import org.objectweb.asm.ClassWriter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import static com.ibm.icu.impl.Assert.fail;
import static org.junit.Assert.*;

public class BetterIntFibonacciBytecodeTest {
    @Test
    public void FibonacciBetterIntBytecode() {
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
        var map = new HashMap<String, byte[]>();
        map.put("Fibonacci", bytes);
        map.put("BetterInt", bytes2);
        BytecodeLoader loader = new BytecodeLoader(map);
        //var Class = loader.findClass("Fibonacci");
        var betterInt = loader.findClass("BetterInt");
        //assertNotNull(Class);
        //assertNotNull(betterInt);
        Object classObject;
        Object betterIntObject;
        try {
            var betterIntConstructor = loader.getConstructor("BetterInt", int.class);
            betterIntObject = betterIntConstructor.newInstance(11);
            var theClass = loader.findClass("Fibonacci");
            assertEquals(theClass.getDeclaredConstructors().length, 1);
            classObject = loader.getConstructor("Fibonacci").newInstance();
            var method = loader.getMethod("Fibonacci", "fibonacci", betterInt);
            assertEquals(betterInt, method.getReturnType());
            assertEquals(89,
                    loader.getField("BetterInt", "x").get(method.invoke(classObject, betterIntObject)));
        }
        catch(IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
            fail("fibonacci" + " failed");
        }
    }
}
