package IntegrationTests;

import General.BytecodeLoader;
import General.ResourceHelper;
import common.Global;
import static org.junit.Assert.*;
import org.junit.Test;

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
        assertEquals(theClass.getConstructors().length, 1);
        var thing = theClass.getConstructors()[0].newInstance(null);
        assertNotNull(thing);
        assertEquals(thing.toString(), "Blablabla");
    }
}
