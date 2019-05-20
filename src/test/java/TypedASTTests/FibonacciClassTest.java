package TypedASTTests;

import astgenerator.expressions.*;
import astgenerator.generalelements.MethodParameter;
import astgenerator.statements.Block;
import astgenerator.statements.IfElse;
import astgenerator.statements.Return;
import common.Global;
import common.ObjectType;
import common.Operators;
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
        var className = "Fibonacci";
        var methodName = "fibonacci";

        var methodParams = new ArrayList<String[]>(){{
            add(new String[]{ObjectType.VoidType.getName(),className});
            add(new String[]{ObjectType.IntType.getName(),methodName});
        }};

        var blocks = new ArrayList<Block>();
        blocks.add(new Block());
        blocks.add(new Block(
                new IfElse(new Binary(new LocalOrFieldVar("n"), new JInteger("1"), Operators.LESSOREQUAL),
                        new Block(new Return(new LocalOrFieldVar("n"))),
                        new Block(new Return(
                                new Binary(
                                        new MethodCallExpression(new This(),methodName,
                                                new ArrayList <>(){{
                                                    add(new Binary(new LocalOrFieldVar("n"), new JInteger("1"), Operators.MINUS));
                                                }}),
                                        new MethodCallExpression(new This(),methodName,new
                                                ArrayList <>(){{
                                                    add(new Binary(new LocalOrFieldVar("n"), new JInteger("2"), Operators.MINUS));
                                                }}),
                                        Operators.PLUS)
                        )))
        ));

        var methodParameters = new ArrayList<ArrayList<MethodParameter>>(){{
            add(new ArrayList <>());
            add(new ArrayList <>(){{
                add(new MethodParameter(ObjectType.IntType, "n"));
            }});
        }};

        var methods = UntypedProgramGenerator.getMethodsWithParams(methodParams, blocks, methodParameters);

        var program = UntypedProgramGenerator.getProgram(className, new ArrayList <>(), methods);

        var typedProgram = Global.getFactory().getTypedAstGenerator().getTypedProgram(program);

        var classCount = typedProgram.getClasses().size();
        var classes = typedProgram.getClasses().get(0);

        assertEquals(classCount, 1);
        assertEquals(classes.getMethods().size(), 2);
        var method = classes.getMethods().get(1);
        assertEquals(method.getParams().size(), 1);
        assertEquals(method.getName(), methodName);
        assertTrue(method.getStmt().getBlockedStatements().get(0) instanceof TypedIfElse);
        TypedIfElse tife = (TypedIfElse) method.getStmt().getBlockedStatements().get(0);
        assertTrue(tife.getThen().getBlockedStatements().get(0) instanceof TypedReturn);
        assertTrue(tife.getOtherwise().getBlockedStatements().get(0) instanceof TypedReturn);
    }
}
