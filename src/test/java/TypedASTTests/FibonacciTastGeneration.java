package TypedASTTests;

import BytecodeTests.TypedProgramGenerator;
import astgenerator.expressions.*;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.MethodCallStatement;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import common.Operators;
import org.junit.Assert;
import org.junit.Test;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.*;

import javax.enterprise.inject.Typed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FibonacciTastGeneration
{
    public static TypedProgram getFibonacciTastRecursion()
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

    public static TypedProgram getFibonacciTastIterative()
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

    public static TypedProgram getFibonacciRecursiveWithBetterInt()
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

        var block = new TypedBlock(ObjectType.IntType,new TypedIfElse(condition, new TypedBlock(ObjectType.getType(betterInt), then), new TypedBlock(ObjectType.getType(betterInt), otherwise), ObjectType.getType(betterInt)));

        var ctor = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                className, new ArrayList<>(), new TypedBlock(new ArrayList<>(), ObjectType.VoidType));
        ctor.setObjectType(ObjectType.VoidType);

        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.getType(betterInt), methodName,
                new ArrayList <>() {{add(new TypedMethodParameter(ObjectType.getType(betterInt), "n"));}}, block);


        return TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{
            add(ctor);
            add(method);
        }});
    }
}
