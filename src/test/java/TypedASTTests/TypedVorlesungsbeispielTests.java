package TypedASTTests;

import General.Vorlesungsbeispiel1;
import common.Global;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypedVorlesungsbeispielTests
{
    @Test
    public void FibonacciRecursiveBetterIntTest()
    {
        var program = Vorlesungsbeispiel1.getVorlesungsbeispiel1Program();
        var typedProgram = Global.getFactory().getTypedAstGenerator().getTypedProgram(program);
        var typedProgramexpected = Vorlesungsbeispiel1.getVorlesungsbeispiel1TypedProgram();
        assertEquals(typedProgramexpected, typedProgram);
    }
}
