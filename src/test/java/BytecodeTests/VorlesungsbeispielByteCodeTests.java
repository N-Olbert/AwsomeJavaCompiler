package BytecodeTests;

import General.BytecodeLoader;
import General.Vorlesungsbeispiel1;
import common.Global;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

public class VorlesungsbeispielByteCodeTests
{
    @Test
    public void testVorlesungsbeispiel1() throws Exception {
        var program = Vorlesungsbeispiel1.getVorlesungsbeispiel1TypedProgram();
        var generator = Global.getFactory().getBytecodeGenerator();
        var byteCode = generator.generate(program);
        assertNotNull(byteCode);
        assertEquals(byteCode.size(), 1);
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("Klassenname");
        assertEquals(theClass.getDeclaredConstructors().length, 1);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance();
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith("Klassenname@"));

        var lt = theClass.getDeclaredMethod("methode", int.class);
        lt.setAccessible(true);
        assertEquals(lt.invoke(thing, 5), 5);
        var field = theClass.getDeclaredField("v");
        field.setAccessible(true);
        field.set(thing, 9);
        assertEquals(lt.invoke(thing, 5), 14);
    }
}
