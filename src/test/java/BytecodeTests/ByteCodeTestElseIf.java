package BytecodeTests;

import General.BytecodeLoader;
import common.Global;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ByteCodeTestElseIf
{
    @Test
    public void BytecodeElseIf()
    {
        var className = "TestwithIfElseIf";
        var methodName = "TestIfElseIf";
        var program = General.TastElseIf.ElseIf();

        var byteCode = Global.getFactory().getBytecodeGenerator().generate(program);

        var loader = new BytecodeLoader(new HashMap <>(){{
            put(className, byteCode.get(0).toByteArray());
        }});

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName, int.class, int.class);

            var result = toTest.invoke(instance, 5, 5);

            assertEquals(5, (int) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }
}
