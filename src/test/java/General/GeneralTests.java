package General;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Method;

public class GeneralTests
{
    @Test
    public void testByteCodeLoader() throws Exception
    {
        InputStream file = ResourceHelper.getFileAsStream("OtherClass.class");
        BytecodeLoader loader = new BytecodeLoader(file.readAllBytes());
        Method m = loader.getMethod("OtherClass", "ggT", int.class, int.class);
        Object result = m.invoke(null, 1000, 2);
        Assert.assertEquals(result, 2);
        result = m.invoke(null, 3, 9);
        Assert.assertEquals(result, 3);
    }
}
