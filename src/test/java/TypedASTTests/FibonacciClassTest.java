package TypedASTTests;

import General.Fibonacci;
import astgenerator.expressions.*;
import astgenerator.generalelements.MethodParameter;
import astgenerator.statements.*;
import common.*;
import org.junit.Test;
import tastgenerator.statements.TypedIfElse;
import tastgenerator.statements.TypedReturn;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FibonacciClassTest
{
    @Test
    public void FibonacciTest()
    {
        var program = Fibonacci.getRecursiveFibonacciProgram();

        var typedProgram = Global.getFactory().getTypedAstGenerator().getTypedProgram(program);

        var typedProgramexpected = Fibonacci.getTypedRecursiveFibonacciProgram();

        assertEquals(typedProgram, typedProgramexpected);
    }

    @Test
    public void FibonacciIterativTest()
    {
        var program = Fibonacci.getIterativeFibonacciProgram();

        var typedProgram = Global.getFactory().getTypedAstGenerator().getTypedProgram(program);

        var typedProgramexpected = Fibonacci.getTypedIterativeFibonacciProgram();

        assertEquals(typedProgramexpected, typedProgram);
    }

    @Test
    public void FibonacciRecursiveBetterIntTest()
    {
        var program = Fibonacci.getRecursiveFibonacciWithBetterIntProgram();

        var typedProgram = Global.getFactory().getTypedAstGenerator().getTypedProgram(program);

        var typedProgramexpected = Fibonacci.getTypedRecursiveBetterIntFibonacciProgram();

        assertEquals(typedProgramexpected, typedProgram);
    }
}
