package BytecodeTests;

import General.BytecodeLoader;
import common.BytecodeGenerator;
import common.Factory;
import common.Global;
import org.junit.Test;
import org.objectweb.asm.ClassWriter;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static BytecodeTests.Point.*;
import static org.junit.Assert.*;


public class PointBytecodeTest {
    @Test
    public void testPoint() {
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        var testProgram = Point.getPointWithGetSetContstructor();

        List<ClassWriter> cws = byteCodeGen.generate(testProgram);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeTests.saveClass(bytes, "target/point.class");
        BytecodeLoader loader = new BytecodeLoader(bytes);
        var Class = loader.findClass(className);
        assertNotNull(Class);
        Object classObject = null;
        try {
            var constructor = loader.getConstructor(className, int.class, int.class);
            assertEquals(className, constructor.getDeclaringClass().getName());
            assertNotNull(classObject = constructor.newInstance(3, 9));
        }
        catch(NoSuchMethodException e) {
            fail("Constructor: \"" + constructorName + "\" not found");
        }
        catch(InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Invoking constructor: \"" + constructorName + " \"");
        }

        try {
            var method = loader.getMethod(className, methodNameGetX);
            assertEquals(int.class, method.getReturnType());
            assertEquals(3, method.invoke(classObject));
        }
        catch(IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            fail(methodNameGetX + " failed");
        }

        try {
            var method = loader.getMethod(className, methodNameGetY);
            assertEquals(int.class, method.getReturnType());
            assertEquals(9, method.invoke(classObject));
        }
        catch(IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            fail(methodNameGetY + " failed");
        }

        try {
            var method = loader.getMethod(className, methodNameSetX, int.class);
            assertEquals(void.class, method.getReturnType());
            method.invoke(classObject, 7);

            var methodGet = loader.getMethod(className, methodNameGetX);
            assertEquals(int.class, methodGet.getReturnType());
            assertEquals(7, methodGet.invoke(classObject));
        }
        catch(IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            fail(methodNameSetX + " failed");
        }

        try {
            var method = loader.getMethod(className, methodNameSetY, int.class);
            assertEquals(void.class, method.getReturnType());
            method.invoke(classObject, 4);
            var methodGet = loader.getMethod(className, methodNameGetY);
            assertEquals(int.class, methodGet.getReturnType());
            assertEquals(4, methodGet.invoke(classObject));
        }
        catch(IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            fail(methodNameSetY + " failed");
        }
    }
}
