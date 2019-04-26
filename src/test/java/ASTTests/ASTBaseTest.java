package ASTTests;

import General.ResourceHelper;
import common.ASTGenerator;
import common.Factory;
import common.Global;
import org.junit.Assert;
import org.junit.Test;
import tastgenerator.generalelements.Program;

import java.io.File;
import java.io.InputStream;

public class ASTBaseTest
{
    @Test
    public void testASTGeneration()
    {
        InputStream file = ResourceHelper.getFileAsStream("BasicClass.java");
        Factory factory = Global.getFactory();
        Assert.assertNotNull(factory);
        ASTGenerator astGen = factory.getASTGenerator();
        Assert.assertNotNull(astGen);
        Program ast = astGen.getAST(file);
        Assert.assertNotNull(ast);

        //Korrekt wäre irgendwas in der Art, wird noch implementiert
        // Program([(CLASS("Test",[],[])])
        Assert.assertEquals(true, true);
    }
}
