package TypedASTTests;

import General.BetterInt;
import astgenerator.generalelements.UntypedProgram;
import common.Global;
import org.junit.Test;
import tastgenerator.generalelements.TypedProgram;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TypedBetterIntTest
{
    @Test
    public void TestBetterIntTyping()
    {
        var ast = BetterInt.getBetterIntProgram();
        var typed = Global.getFactory().getTypedAstGenerator().getTypedProgram(ast);
        assertEquals(typed, BetterInt.getTypedBetterIntProgram());
    }
}
