package General;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Custom Classloader which loads the given byte array.
 */
public class BytecodeLoader extends ClassLoader
{
    private byte[] byteCode;
    private Class<?> clazz;

    public BytecodeLoader(byte[] byteCode)
    {
        this.byteCode = byteCode;
    }

    @Override
    public Class findClass(String name)
    {
        if(clazz != null) {
            return clazz;
        }
        else {
            return clazz = defineClass(name, byteCode, 0, byteCode.length);
        }
    }

    public Method getMethod(String className, String method, Class<?>... parameterTypes) throws NoSuchMethodException
    {
        return findClass(className).getMethod(method, parameterTypes);
    }

    public Field getField(String className, String field) throws NoSuchFieldException
    {
        return findClass(className).getDeclaredField(field);
    }
}
