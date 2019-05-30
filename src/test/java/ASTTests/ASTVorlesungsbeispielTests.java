package ASTTests;

import General.*;
import common.Global;
import org.junit.Test;

import java.io.InputStream;
import java.io.SequenceInputStream;

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

    @Test
    public void TestASTGenForVorlesungsbeispiel2Extended1()
    {
        InputStream file1 = ResourceHelper.getFileAsStream("Vorlesungsbeispiel2.java");
        InputStream file2 = ResourceHelper.getFileAsStream("Vorlesungsbeispiel2_Extended.java");
        var stream = new SequenceInputStream(file1, file2);
        var astGen = Global.getFactory().getASTGenerator();
        var ast = astGen.getAST(stream);
        assertEquals(ast, Vorlesungsbeispiel2Extended.getVorlesungsbeispiel2Extended1Program());
    }

    @Test
    public void TestASTGenForVorlesungsbeispiel2Extended2()
    {
        InputStream file1 = ResourceHelper.getFileAsStream("Vorlesungsbeispiel2.java");
        InputStream file2 = ResourceHelper.getFileAsStream("Vorlesungsbeispiel2_Extended2.java");
        var stream = new SequenceInputStream(file1, file2);
        var astGen = Global.getFactory().getASTGenerator();
        var ast = astGen.getAST(stream);
        assertEquals(ast, Vorlesungsbeispiel2Extended.getVorlesungsbeispiel2Extended2Program());
    }
}
