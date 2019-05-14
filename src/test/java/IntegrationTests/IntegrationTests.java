package IntegrationTests;

import General.BytecodeLoader;
import General.ResourceHelper;
import common.Global;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class IntegrationTests
{
    @Test
    public void testBasicClass() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        var file = ResourceHelper.getFileAsStream("BasicClass.java");
        var ast = Global.getFactory().getASTGenerator().getAST(file);
        var typedAst = Global.getFactory().getTypedAstGenerator().getTypedProgram(ast);
        var byteCode = Global.getFactory().getBytecodeGenerator().generate(typedAst);
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("Test");
        assertEquals(theClass.getDeclaredConstructors().length, 1);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance(null);
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith("Test@"));
    }
}
