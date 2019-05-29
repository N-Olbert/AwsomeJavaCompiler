package ASTTests;

import General.Fibonacci;
import General.ResourceHelper;
import General.Vorlesungsbeispiel1;
import General.Vorlesungsbeispiel2;
import common.Global;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class ASTVorlesungsbeispielTests
{
    @Test
    public void TestASTGenForVorlesungsbeispiel1()
    {
        InputStream file = ResourceHelper.getFileAsStream("Vorlesungsbeispiel1.java");
        var astGen = Global.getFactory().getASTGenerator();
        var ast = astGen.getAST(file);
        assertEquals(ast, Vorlesungsbeispiel1.getVorlesungsbeispiel1Program());
    }

    @Test
    public void TestASTGenForVorlesungsbeispiel2()
    {
        InputStream file = ResourceHelper.getFileAsStream("Vorlesungsbeispiel2.java");
        var astGen = Global.getFactory().getASTGenerator();
        var ast = astGen.getAST(file);
        assertEquals(ast, Vorlesungsbeispiel2.getVorlesungsbeispiel2Program());
    }
}
