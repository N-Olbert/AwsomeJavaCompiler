package ASTTests;

import General.ResourceHelper;
import astgenerator.expressions.*;
import astgenerator.generalelements.Class;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.Block;
import astgenerator.statements.IfElse;
import astgenerator.statements.Return;
import astgenerator.statements.Statement;
import common.*;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ASTFibonacciRekursiv {

    @Test
    public void TestASTGenForFibonacci()
    {
        InputStream file = ResourceHelper.getFileAsStream("Fibonacci.java");
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        ASTGenerator astGen = factory.getASTGenerator();
        assertNotNull(astGen);

        String className = "Fibonacci";
        String methodName = "fibonacci";
        Class testClass = new Class(ObjectType.getType(className), new ArrayList<>(), new ArrayList<MethodDeclaration>());
        testClass.getMethods().add(new MethodDeclaration
                (AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType, className, new ArrayList<>(), new Block()));

        var methodParams = new ArrayList<MethodParameter>();
        methodParams.add(new MethodParameter(ObjectType.IntType, "n"));

        var condition = new Binary(new LocalOrFieldVar("n")
                ,new JInteger("1"),
                Operators.LESSOREQUAL);
        var then = new Return(new LocalOrFieldVar("n"));
        var nMinusOne = new Binary(new LocalOrFieldVar("n"),
                new JInteger("1"),
                Operators.MINUS);
        var nMinusTwo = new Binary(new LocalOrFieldVar("n"),
                new JInteger("2"),
                Operators.MINUS);
        var otherwise =
                new Return(
                        new Binary(
                                new MethodCallExpression(new This(), methodName, new ArrayList<>(){{add(nMinusOne);}}),
                                new MethodCallExpression(new This(), methodName, new ArrayList<>(){{add(nMinusTwo);}}),
                                Operators.PLUS
                        )
                );

        var thenBlock = new Block(then);
        var elseBlock = new Block(otherwise);
        var statements = new ArrayList<Statement>();
        statements.add(
                new IfElse(condition, thenBlock, elseBlock));


        var methodBody = new Block(statements);
        var method = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.IntType, methodName, methodParams, methodBody);

        testClass.getMethods().add(method);
        UntypedProgram testProgram = new UntypedProgram();
        List<Class> classes = new ArrayList<Class>();
        classes.add(testClass);
        testProgram.setClasses(classes);

        UntypedProgram untypedAST = astGen.getAST(file);
        var untypedClass = untypedAST.getClasses().get(0);
        assertNotNull(untypedAST);
        assertEquals(1 ,untypedAST.getClasses().size());
        assertEquals(untypedClass.getClassType(), ObjectType.getType(className));

        assertEquals(testClass.getFields().size(), untypedClass.getFields().size());
        assertEquals(testClass.getMethods().size(), untypedClass.getMethods().size());

        var ctor = untypedClass.getMethods().get(0);
        var expectedCtor = testClass.getMethods().get(0);
        assertEquals(expectedCtor.getAccessModifier(), ctor.getAccessModifier());
        assertEquals(expectedCtor.getModifier(), ctor.getModifier());
        assertEquals(expectedCtor.getName(), ctor.getName());
        assertEquals(expectedCtor.getParams().size(), ctor.getParams().size());
        assertTrue(ctor.getStmt() instanceof Block);
        assertEquals(((Block)expectedCtor.getStmt()).getBlockedStatements().size(), ((Block)ctor.getStmt()).getBlockedStatements().size());
        assertEquals(expectedCtor.getReturnType(), ctor.getReturnType());

        var fibonacciMethod = untypedClass.getMethods().get(1);
        var expFibonacci = testClass.getMethods().get(1);

        assertEquals(expFibonacci.getReturnType(), fibonacciMethod.getReturnType());
        assertEquals(expFibonacci.getParams().size(), fibonacciMethod.getParams().size());
        assertEquals(expFibonacci.getName(), fibonacciMethod.getName());
        assertEquals(expFibonacci.getAccessModifier(), fibonacciMethod.getAccessModifier());
        assertEquals(expFibonacci.getModifier(), fibonacciMethod.getModifier());

        var stmt = (Block)fibonacciMethod.getStmt();
        var firstStmt = (IfElse)stmt.getBlockedStatements().get(0);

        var exp = (Binary)firstStmt.getCondition();
        var exp1 = (LocalOrFieldVar)exp.getExpression();
        var exp2 = (JInteger)exp.getExpression2();
        var operator = exp.getOperator();
        assertEquals("n", exp1.getName());
        assertEquals(1, exp2.getJint());
        assertEquals(Operators.LESSOREQUAL, operator);
    }
}
