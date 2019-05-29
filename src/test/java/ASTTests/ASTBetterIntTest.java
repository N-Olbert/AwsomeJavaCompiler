package ASTTests;

import General.BetterInt;
import General.ResourceHelper;
import common.Global;
import org.junit.Test;

import static org.junit.Assert.*;

public class ASTBetterIntTest
{
    @Test
    public void testAstParseTreeGeneration()
    {
        var file = ResourceHelper.getFileAsStream("BetterInt.java");
        var generator = Global.getFactory().getASTGenerator();
        var ast = generator.getAST(file);
        assertEquals(BetterInt.getBetterIntProgram(), ast);
    }
}
