package TypedASTTests;

import astgenerator.expressions.*;
import astgenerator.generalelements.MethodParameter;
import astgenerator.statements.*;
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

    @Test
    public void FibonacciIterativTest()
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
                new IfElse(new Binary(new LocalOrFieldVar("n"), new JInteger("2"), Operators.LESSTHAN),
                        new Block(new Return(new JInteger("1"))),
                        new Block(
                                new LocalVarDeclaration(ObjectType.IntType, "a"),
                                new AssignStatement(new LocalOrFieldVar("a"), new JInteger("0")),
                                new LocalVarDeclaration(ObjectType.IntType, "b"),
                                new AssignStatement(new LocalOrFieldVar("b"), new JInteger("1")),
                                new LocalVarDeclaration(ObjectType.IntType, "i"),
                                new AssignStatement(new LocalOrFieldVar("i"), new JInteger("3")),
                                new LocalVarDeclaration(ObjectType.IntType, "temp"),
                                new While(new Binary(new LocalOrFieldVar("i"), new LocalOrFieldVar("n"), Operators.LESSOREQUAL),
                                        new Block(
                                                new AssignStatement(new LocalOrFieldVar("temp"), new LocalOrFieldVar("b")),
                                                new AssignStatement(new LocalOrFieldVar("b"),
                                                        new Binary(new LocalOrFieldVar("b"), new LocalOrFieldVar("a"), Operators.PLUS)),
                                                new AssignStatement(new LocalOrFieldVar("a"), new LocalOrFieldVar("temp")),
                                                new AssignStatement(new LocalOrFieldVar("i"),
                                                        new Binary(new LocalOrFieldVar("i"), new JInteger("1"), Operators.PLUS))
                                        )
                                ),
                                new Return(new Binary(new LocalOrFieldVar("a"), new LocalOrFieldVar("b"), Operators.PLUS))
                        )
                )
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
        assertTrue(tife.getOtherwise().getBlockedStatements().get(9) instanceof TypedReturn);
    }
}
