package BytecodeTests;

import General.BetterInt;
import General.BytecodeLoader;
import common.Global;
import org.junit.Test;
import tastgenerator.generalelements.TypedProgram;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

public class BetterIntByteCodeTests
{
    @Test
    public void testBetterIntClass() throws Exception
    {
        var program = BetterInt.getTypedBetterIntProgram();
        var generator = Global.getFactory().getBytecodeGenerator();
        var byteCode = generator.generate(program);
        assertNotNull(byteCode);
        assertEquals(byteCode.size(), 1);
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("BetterInt");
        assertEquals(theClass.getDeclaredConstructors().length, 2);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance(5);
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith("BetterInt@"));
        var field = theClass.getField("x");
        assertNotNull(field);
        assertEquals(5, field.get(thing));
    }
}
