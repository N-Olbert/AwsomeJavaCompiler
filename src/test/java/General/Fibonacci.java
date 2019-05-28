package General;

import BytecodeTests.TypedProgramGenerator;
import TypedASTTests.UntypedProgramGenerator;
import astgenerator.expressions.*;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.*;
import common.*;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Fibonacci
{
    public static TypedProgram getTypedRecursiveFibonacciProgram()
    {
        var className = "Fibonacci";
        var classType = ObjectType.getType(className);
        var methodName = "fibonacci";
        var methodParams = new ArrayList <TypedMethodParameter>();
        methodParams.add(new TypedMethodParameter(ObjectType.IntType, "n"));
        var condition = new TypedBinary(
                new TypedLocalOrFieldVar(ObjectType.IntType, "n"),
                new TypedInt("1"),
                Operators.LESSOREQUAL, ObjectType.BoolType);
        var then = new TypedReturn(new TypedLocalOrFieldVar(ObjectType.IntType, "n"), ObjectType.IntType);
        var nMinusOne = new TypedBinary(new TypedLocalOrFieldVar(ObjectType.IntType, "n"),
                new TypedInt("1"), Operators.MINUS, ObjectType.IntType);
        var nMinusTwo = new TypedBinary(new TypedLocalOrFieldVar(ObjectType.IntType, "n"),
                new TypedInt("2"), Operators.MINUS, ObjectType.IntType);
        var otherwise =
                new TypedReturn(
                        new TypedBinary(
                                new TypedMethodCallExpression(new TypedThis(classType), methodName, new ArrayList<>() {{
                                    add(nMinusOne);
                                }}, ObjectType.IntType),
                                new TypedMethodCallExpression(new TypedThis(classType), methodName, new ArrayList<>() {{
                                    add(nMinusTwo);
                                }}, ObjectType.IntType),
                                Operators.PLUS, ObjectType.IntType),
                        ObjectType.IntType);

        var statements = new ArrayList<TypedStatement>();
        statements.add(new TypedIfElse(condition,
                new TypedBlock(new ArrayList<>() {{
                    add(then);
                }}, ObjectType.IntType),
                new TypedBlock(new ArrayList<>() {{
                    add(otherwise);
                }}, ObjectType.IntType), ObjectType.IntType));

        var methodBody = new TypedBlock(statements, ObjectType.IntType);
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.IntType,
                "fibonacci", methodParams, methodBody);

        var ctor = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                className, new ArrayList<>(), new TypedBlock(new ArrayList<>(), ObjectType.VoidType));
        ctor.setObjectType(ObjectType.VoidType);
        return TypedProgramGenerator.getProgram(className, new ArrayList <>(),
                new ArrayList<>() {{
                    add(ctor);
                    add(method);
                }});
    }

    public static TypedProgram getTypedIterativeFibonacciProgram()
    {
        var className = "Fibonacci";
        var methodName = "fibonacci";

        /*
         *         if(n <2)
         *         {
         *             return 1;
         *         }
         *         else
         *         {
         *             int a=0;
         *             int b=1;
         *             int i=3;
         *             int temp;
         *             while(i<= n)
         *             {
         *                 temp=b;
         *                 b=a+b;
         *                 a=temp;
         *                 i++;
         *             }
         *
         *             return a + b;
         *         }
         */
        var methodParams = new ArrayList<TypedMethodParameter>();
        methodParams.add(new TypedMethodParameter(ObjectType.IntType, "n"));
        var condition = new TypedBinary(
                new TypedLocalOrFieldVar(ObjectType.IntType, "n"),
                new TypedInt("2"),
                Operators.LESSTHAN, ObjectType.BoolType);
        var then = new TypedReturn(new TypedInt("1"), ObjectType.IntType);
        var otherwise = new ArrayList<TypedStatement>();
        otherwise.add(new TypedLocalVarDeclaration(ObjectType.IntType, "a"));
        otherwise.add(new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.IntType, "a"), new TypedInt("0")));
        otherwise.add(new TypedLocalVarDeclaration(ObjectType.IntType, "b"));
        otherwise.add(new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.IntType, "b"), new TypedInt("1")));
        otherwise.add(new TypedLocalVarDeclaration(ObjectType.IntType, "i"));
        otherwise.add(new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.IntType, "i"), new TypedInt("3")));
        otherwise.add(new TypedLocalVarDeclaration(ObjectType.IntType, "temp"));
        var loopStmt = new ArrayList<TypedStatement>();
        var loop = new TypedWhile(new TypedBinary(new TypedLocalOrFieldVar(ObjectType.IntType, "i"),
                new TypedLocalOrFieldVar(ObjectType.IntType, "n"),
                Operators.LESSOREQUAL, ObjectType.BoolType),
                new TypedBlock(loopStmt, ObjectType.VoidType), ObjectType.VoidType);
        otherwise.add(loop);
        loopStmt.add(new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.IntType, "temp"),
                new TypedLocalOrFieldVar(ObjectType.IntType, "b")));
        loopStmt.add(new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.IntType, "b"),
                new TypedBinary(new TypedLocalOrFieldVar(ObjectType.IntType, "b"),
                        new TypedLocalOrFieldVar(ObjectType.IntType, "a"), Operators.PLUS, ObjectType.IntType)));
        loopStmt.add(new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.IntType, "a"),
                new TypedLocalOrFieldVar(ObjectType.IntType, "temp")));
        loopStmt.add(new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.IntType, "i"),
                new TypedBinary(new TypedLocalOrFieldVar(ObjectType.IntType, "i"),
                        new TypedInt("1"), Operators.PLUS, ObjectType.IntType)));
        otherwise.add(new TypedReturn(
                new TypedBinary(
                        new TypedLocalOrFieldVar(ObjectType.IntType, "a"),
                        new TypedLocalOrFieldVar(ObjectType.IntType, "b"), Operators.PLUS, ObjectType.IntType),
                ObjectType.IntType));

        var statements = new ArrayList<TypedStatement>();
        statements.add(new TypedIfElse(condition,
                new TypedBlock(new ArrayList<>() {{
                    add(then);
                }}, ObjectType.IntType),
                new TypedBlock(otherwise, ObjectType.IntType), ObjectType.IntType));

        var methodBody = new TypedBlock(statements, ObjectType.IntType);
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.IntType,
                methodName, methodParams, methodBody);

        var ctor = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                className, new ArrayList<>(), new TypedBlock(new ArrayList<>(), ObjectType.VoidType));
        ctor.setObjectType(ObjectType.VoidType);
        return TypedProgramGenerator.getProgram(className, new ArrayList <>(),
                new ArrayList<>() {{
                    add(ctor);
                    add(method);
                }});
    }

    public static TypedProgram getTypedRecursiveBetterIntFibonacciProgram()
    {
        var className = "Fibonacci";
        var classType = ObjectType.getType(className);
        var methodName = "fibonacci";
        var betterInt = "BetterInt";
        var condition = new TypedMethodCallExpression(
                new TypedLocalOrFieldVar(ObjectType.getType(betterInt), "n"), "LessThan",
                new ArrayList <>(){{
                    add(new TypedNewExpression(ObjectType.getType(betterInt),
                            new ArrayList <>(){{
                                add(new TypedInt("2"));
                            }})
                    );
                }} ,
                ObjectType.BoolType
        );
        var innermethodCall1 = new ArrayList<TypedExpression>() {{
            add(new TypedNewExpression(ObjectType.getType(betterInt), new ArrayList <>(){{add(new TypedInt("1"));}}));
        }};
        var methodCall1 = new ArrayList<TypedExpression>() {{
            add(new TypedMethodCallExpression(new TypedLocalOrFieldVar(ObjectType.getType(betterInt), "n"),
                    "Subtract", innermethodCall1, ObjectType.getType(betterInt)));
        }};

        var innermethodCall3 = new ArrayList<TypedExpression>() {{
            add(new TypedNewExpression(ObjectType.getType(betterInt), new ArrayList <>(){{add(new TypedInt("2"));}}));
        }};
        var innermethodCall2 = new ArrayList<TypedExpression>(){{
            add(new TypedMethodCallExpression(new TypedLocalOrFieldVar(ObjectType.getType(betterInt), "n"), "Subtract", innermethodCall3, ObjectType.getType(betterInt)));
        }};
        var methodCall2 = new ArrayList<TypedExpression>() {{
            add(new TypedMethodCallExpression(new TypedThis(classType), methodName, innermethodCall2, ObjectType.getType(betterInt)));
        }};
        var then = new TypedReturn(new TypedLocalOrFieldVar(ObjectType.getType(betterInt), "n"), ObjectType.getType(betterInt));
        var otherwise = new TypedReturn(
                new TypedMethodCallExpression(
                        new TypedMethodCallExpression(new TypedThis(classType), methodName, methodCall1,ObjectType.getType(betterInt)),
                        "Add",
                        methodCall2,
                        ObjectType.getType(betterInt))
                , ObjectType.getType(betterInt)
        );

        var block = new TypedBlock(ObjectType.getType(betterInt),new TypedIfElse(condition, new TypedBlock(ObjectType.getType(betterInt), then), new TypedBlock(ObjectType.getType(betterInt), otherwise), ObjectType.getType(betterInt)));

        var ctor = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                className, new ArrayList<>(), new TypedBlock(new ArrayList<>(), ObjectType.VoidType));
        ctor.setObjectType(ObjectType.VoidType);

        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.getType(betterInt), methodName,
                new ArrayList <>() {{add(new TypedMethodParameter(ObjectType.getType(betterInt), "n"));}}, block);


        var prog = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{
            add(ctor);
            add(method);
        }});
        prog.getClasses().add(BetterInt.getTypedBetterIntClass());
        return prog;
    }

    public static UntypedProgram getRecursiveFibonacciProgram()
    {
        var className = "Fibonacci";
        var methodName = "fibonacci";

        var methodParams = new ArrayList<String[]>(){{
            add(new String[]{ObjectType.VoidType.getName(),className});
            add(new String[]{String.valueOf(AccessModifier.PUBLIC), String.valueOf(Modifier.NONE),ObjectType.IntType.getName(),methodName});
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
        return program;
    }

    public static UntypedProgram getIterativeFibonacciProgram()
    {
        var className = "Fibonacci";
        var methodName = "fibonacci";

        var methodParams = new ArrayList<String[]>(){{
            add(new String[]{ObjectType.VoidType.getName(),className});
            add(new String[]{String.valueOf(AccessModifier.PUBLIC), String.valueOf(Modifier.NONE),ObjectType.IntType.getName(),methodName});
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
        return program;
    }

    public static UntypedProgram getRecursiveFibonacciWithBetterIntProgram()
    {
        var className = "Fibonacci";
        var methodName = "fibonacci";
        var bIType = ObjectType.getType("BetterInt");
        var methodParams = new ArrayList<MethodParameter>();
        methodParams.add(new MethodParameter(bIType, "n"));
        var methodBlock = new Block(new ArrayList<>());
        var methodDecl = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, bIType,
                                                methodName, methodParams, methodBlock);
        var condition = new MethodCallExpression(
                new LocalOrFieldVar("n"), "LessThan",
                new ArrayList <>(){{
                    add(new NewExpression(bIType,
                            new ArrayList <>(){{
                                add(new JInteger("2"));
                            }})
                    );
                }}
        );
        var then = new Return(new LocalOrFieldVar("n"));
        var firstMethodParams = new ArrayList<Expression>();
        var firstCall = new MethodCallExpression(new This(), methodName, firstMethodParams);
        //return fibonacci(n.Subtract(new BetterInt(1))).Add(fibonacci(n.Subtract(new BetterInt(2))));
        firstMethodParams.add(new MethodCallExpression(
                new LocalOrFieldVar("n"),"Subtract",
                    new ArrayList<>(){{
                        add(new NewExpression(bIType, new ArrayList<>() {{add(new JInteger("1"));}}));;}}));

        var secondMethodParams = new ArrayList<Expression>();
        secondMethodParams.add(new MethodCallExpression(
                new LocalOrFieldVar("n"),"Subtract",
                    new ArrayList<>(){{
                        add(new NewExpression(bIType, new ArrayList<>() {{add(new JInteger("2"));}}));;}}));
        var secondCall = new MethodCallExpression(new This(), methodName, secondMethodParams);

        var otherwise = new Return(new MethodCallExpression(firstCall, "Add",
                new ArrayList<>(){{add(secondCall);}}));
        methodBlock.getBlockedStatements().add(new IfElse(condition, new Block(then), new Block(otherwise)));
        var ctor = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType, className,
                new ArrayList<>(),
                new Block(new ArrayList<>()));
        var methods = new ArrayList<MethodDeclaration>();
        methods.add(ctor);
        methods.add(methodDecl);
        var prog = UntypedProgramGenerator.getProgram(className, new ArrayList<>(), methods);
        prog.getClasses().add(BetterInt.getBetterIntClass()); //for type check;
        return prog;
    }
}
