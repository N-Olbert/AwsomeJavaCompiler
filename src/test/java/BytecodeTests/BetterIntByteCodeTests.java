package BytecodeTests;

import General.BetterInt;
import General.BytecodeLoader;
import common.Global;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

public class BetterIntByteCodeTests {
    @Test
    public void testBetterIntClass() throws Exception {
        var program = BetterInt.getTypedBetterIntProgram();
        var generator = Global.getFactory().getBytecodeGenerator();
        var byteCode = generator.generate(program);
        assertNotNull(byteCode);
        assertEquals(byteCode.size(), 1);
        BytecodeTests.saveClass(byteCode.get(0).toByteArray(), "target/BetterInt.class");
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("BetterInt");
        assertEquals(theClass.getDeclaredConstructors().length, 2);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var bi5 = constructor.newInstance(5);
        assertNotNull(bi5);
        System.out.println(bi5.toString());
        assertTrue(bi5.toString().startsWith("BetterInt@"));
        var field = theClass.getField("x");
        assertNotNull(field);
        assertEquals(5, field.get(bi5));

        var bi10 = constructor.newInstance(10);
        var biM5 = constructor.newInstance(-5);
        var lt = theClass.getDeclaredMethod("LessThan", theClass);
        lt.setAccessible(true);
        assertTrue((boolean) lt.invoke(bi5, bi10));
        assertFalse((boolean) lt.invoke(bi5, biM5));

        var add = theClass.getDeclaredMethod("Add", theClass);
        add.setAccessible(true);

        var sub = theClass.getDeclaredMethod("Subtract", theClass);
        sub.setAccessible(true);
        var res = sub.invoke(bi10, bi5);
        assertNotNull(res);

        var biResult = add.invoke(bi10, biM5);
        assertNotNull(biResult);
        assertEquals(5, field.get(biResult));

    }
}
