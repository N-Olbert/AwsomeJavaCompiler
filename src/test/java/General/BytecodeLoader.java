package General;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Custom Classloader which loads the given byte array.
 */
public class BytecodeLoader extends ClassLoader {
    private byte[] byteCode;
    private Class<?> clazz;

    public BytecodeLoader(byte[] byteCode) {
        this.byteCode = byteCode;
    }

    @Override
    public Class findClass(String name) {
        if(clazz != null) {
            return clazz;
        }
        else {
            return clazz = defineClass(name, byteCode, 0, byteCode.length);
        }
    }

    public Method getMethod(String className, String method, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method method1 = findClass(className).getDeclaredMethod(method, parameterTypes);
        method1.setAccessible(true);
        return method1;
    }

    public Field getField(String className, String field) throws NoSuchFieldException {
        Field field1 = findClass(className).getDeclaredField(field);
        field1.setAccessible(true);
        return field1;
    }

    public Constructor getConstructor(String classname, Class<?>... parameterTyped) throws NoSuchMethodException {
        Constructor<?> constructor = findClass(classname).getDeclaredConstructor(parameterTyped);
        constructor.setAccessible(true);
        return constructor;
    }
}
