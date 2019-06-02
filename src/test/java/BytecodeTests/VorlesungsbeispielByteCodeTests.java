package BytecodeTests;

import General.BytecodeLoader;
import General.Vorlesungsbeispiel1;
import General.Vorlesungsbeispiel2;
import General.Vorlesungsbeispiel2Extended;
import common.Global;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class VorlesungsbeispielByteCodeTests {
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
        var map = new HashMap<String, byte[]>() {{
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
        var m2 = c2Thing.getClass().getDeclaredMethod("m2", loader.findClass("Cl3"), int.class);
        m2.setAccessible(true);
        var result = m2.invoke(c2Thing, c3Thing, 5);
        assertEquals(result, '4');
        var m1 = c1Thing.getClass().getDeclaredMethod("m1");
        m1.setAccessible(true);
        try {
            m1.invoke(c1Thing);
            fail();
        }
        catch(InvocationTargetException expected) {
            if(!(expected.getCause() instanceof NullPointerException)) {
                fail();
            }
        }
    }

    @Test
    public void testVorlesungsbeispiel2Extended1() throws Exception {
        var program = Vorlesungsbeispiel2Extended.getVorlesungsbeispiel2Extended1TypedProgram();
        var generator = Global.getFactory().getBytecodeGenerator();
        var byteCode = generator.generate(program);
        assertNotNull(byteCode);
        assertEquals(byteCode.size(), 4);
        var map = new HashMap<String, byte[]>() {{
            put("Cl1", byteCode.get(0).toByteArray());
            put("Cl2", byteCode.get(1).toByteArray());
            put("Cl3", byteCode.get(2).toByteArray());
            put("Cl4", byteCode.get(3).toByteArray());
        }};

        for(String key : map.keySet()) {
            BytecodeTests.saveClass(map.get(key), "target/" + key + "(2).class");
        }

        var loader = new BytecodeLoader(map);
        var c2Thing = getThing(loader, "Cl2");
        var c3Thing = getThing(loader, "Cl3");
        var c4Thing = getThing(loader, "Cl4");


        var testTypeObjectReturn = c4Thing.getClass()
                .getDeclaredMethod("testTypeObjectReturn", loader.findClass("Cl3"), loader.findClass("Cl2"));
        testTypeObjectReturn.setAccessible(true);
        var result = testTypeObjectReturn.invoke(c4Thing, null, c2Thing);
        assertEquals(result, c2Thing);
        result = testTypeObjectReturn.invoke(c4Thing, c3Thing, c2Thing);
        assertEquals(result, c3Thing);
    }

    @Test
    public void testVorlesungsbeispiel2Extended2() throws Exception {
        var program = Vorlesungsbeispiel2Extended.getVorlesungsbeispiel2Extended2TypedProgram();
        var generator = Global.getFactory().getBytecodeGenerator();
        var byteCode = generator.generate(program);
        assertNotNull(byteCode);
        assertEquals(byteCode.size(), 4);
        var map = new HashMap<String, byte[]>() {{
            put("Cl1", byteCode.get(0).toByteArray());
            put("Cl2", byteCode.get(1).toByteArray());
            put("Cl3", byteCode.get(2).toByteArray());
            put("Cl5", byteCode.get(3).toByteArray());
        }};

        for(String key : map.keySet()) {
            BytecodeTests.saveClass(map.get(key), "target/" + key + ".class");
        }

        var loader = new BytecodeLoader(map);
        var c5Thing = getThing(loader, "Cl5");

        var testWideningReturn = c5Thing.getClass().getDeclaredMethod("testWideningReturn", int.class, char.class);
        testWideningReturn.setAccessible(true);
        var result = testWideningReturn.invoke(c5Thing, 1, 'h');
        assertEquals(result, 1);
        result = testWideningReturn.invoke(c5Thing, 8, 'h');
        assertEquals(result, (int) 'h');
    }

    private Object getThing(BytecodeLoader loader, String className) throws Exception {
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
