package ASTTests;

import General.Fibonacci;
import General.ResourceHelper;
import common.*;
import org.junit.Test;

import java.io.InputStream;
import java.io.SequenceInputStream;

import static org.junit.Assert.*;

public class ASTFibonacciTests
{

    @Test
    public void TestASTGenForRecursiveFibonacci()
    {
        InputStream file = ResourceHelper.getFileAsStream("Fibonacci.java");
        var astGen = Global.getFactory().getASTGenerator();
        var ast = astGen.getAST(file);
        assertEquals(ast, Fibonacci.getRecursiveFibonacciProgram());
    }

    @Test
    public void TestASTGenForIterativeFibonacci()
    {
        InputStream file = ResourceHelper.getFileAsStream("Fibonacci_Iter.java");
        var astGen = Global.getFactory().getASTGenerator();
        var ast = astGen.getAST(file);
        assertEquals(ast, Fibonacci.getRecursiveFibonacciProgram());
    }

    @Test
    public void TestASTGenForBetterIntFibonacci()
    {
        InputStream file1 = ResourceHelper.getFileAsStream("BetterInt.java");
        InputStream file2 = ResourceHelper.getFileAsStream("FibonacciWithBetterInt.java");
        var file = new SequenceInputStream(file1, file2);
        var astGen = Global.getFactory().getASTGenerator();
        var ast = astGen.getAST(file);
        assertEquals(ast, Fibonacci.getTypedRecursiveBetterIntFibonacciProgram());
    }
}
