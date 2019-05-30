package TypedASTTests;

import General.Vorlesungsbeispiel1;
import General.Vorlesungsbeispiel2;
import General.Vorlesungsbeispiel2Extended;
import common.Global;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypedVorlesungsbeispielTests
{
    @Test
    public void Vorlesungsbeispiel1Test()
    {
        var program = Vorlesungsbeispiel1.getVorlesungsbeispiel1Program();
        var typedProgram = Global.getFactory().getTypedAstGenerator().getTypedProgram(program);
        var typedProgramexpected = Vorlesungsbeispiel1.getVorlesungsbeispiel1TypedProgram();
        assertEquals(typedProgramexpected, typedProgram);
    }

    @Test
    public void Vorlesungsbeispiel2Test()
    {
        var program = Vorlesungsbeispiel2.getVorlesungsbeispiel2Program();
        var typedProgram = Global.getFactory().getTypedAstGenerator().getTypedProgram(program);
        var typedProgramexpected = Vorlesungsbeispiel2.getVorlesungsbeispiel2TypedProgram();
        assertEquals(typedProgramexpected, typedProgram);
    }

    @Test
    public void Vorlesungsbeispiel2Extended1Test()
    {
        var program = Vorlesungsbeispiel2Extended.getVorlesungsbeispiel2Extended1Program();
        var typedProgram = Global.getFactory().getTypedAstGenerator().getTypedProgram(program);
        var typedProgramexpected = Vorlesungsbeispiel2Extended.getVorlesungsbeispiel2Extended1TypedProgram();;
        assertEquals(typedProgramexpected, typedProgram);
    }

    @Test
    public void Vorlesungsbeispiel2Extended2Test()
    {
        var program = Vorlesungsbeispiel2Extended.getVorlesungsbeispiel2Extended2Program();
        var typedProgram = Global.getFactory().getTypedAstGenerator().getTypedProgram(program);
        var typedProgramexpected = Vorlesungsbeispiel2Extended.getVorlesungsbeispiel2Extended2TypedProgram();;
        assertEquals(typedProgramexpected, typedProgram);
    }
}
