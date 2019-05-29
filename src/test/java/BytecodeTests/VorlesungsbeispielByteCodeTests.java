package BytecodeTests;

import General.BytecodeLoader;
import General.Vorlesungsbeispiel1;
import General.Vorlesungsbeispiel2;
import common.Global;
import common.ObjectType;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.HashMap;

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

    @Test
    public void testVorlesungsbeispiel2() throws Exception {
        var program = Vorlesungsbeispiel2.getVorlesungsbeispiel2TypedProgram();
        var generator = Global.getFactory().getBytecodeGenerator();
        var byteCode = generator.generate(program);
        assertNotNull(byteCode);
        assertEquals(byteCode.size(), 3);
        var map = new HashMap<String, byte[]>(){{
            put("Cl1", byteCode.get(0).toByteArray());
            put("Cl2", byteCode.get(1).toByteArray());
            put("Cl3", byteCode.get(2).toByteArray());
        }};

        var loader = new BytecodeLoader(map);
        var c1Thing = getThing(loader, "Cl1");
        var c2Thing = getThing(loader, "Cl2");
        var c3Thing = getThing(loader, "Cl3");

        var y = c3Thing.getClass().getDeclaredField("y");
        y.setAccessible(true);
        y.set(c3Thing, '4'); //52
        var m2 = c2Thing.getClass().getDeclaredMethods()[0];
        var result = m2.invoke(c2Thing, c3Thing, 5);
        assertEquals(result, '4');
        var m1 = c1Thing.getClass().getDeclaredMethod("m1");
        try
        {
            m1.invoke(c1Thing);
            fail();
        }
        catch (NullPointerException expected)
        {
        }
    }

    private Object getThing(BytecodeLoader loader, String className) throws Exception
    {
        var c1 = loader.findClass(className);
        assertEquals(c1.getDeclaredConstructors().length, 1);
        Constructor constructor = c1.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance();
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith(className));
        return thing;
    }
}
