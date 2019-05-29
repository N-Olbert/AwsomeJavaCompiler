package General;

import BytecodeTests.TypedProgramGenerator;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import common.Operators;
import tastgenerator.expressions.TypedBinary;
import tastgenerator.expressions.TypedInt;
import tastgenerator.expressions.TypedLocalOrFieldVar;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.*;

import java.util.ArrayList;

public class TastElseIf
{
    public static TypedProgram ElseIf()
    {
        var className = "TestwithIfElseIf";
        var methodName = "TestIfElseIf";

        var methodParams = new ArrayList <String[]>(){{
            add(new String[]{ObjectType.VoidType.getName(),className});
            add(new String[]{String.valueOf(AccessModifier.PUBLIC), String.valueOf(Modifier.NONE),ObjectType.IntType.getName(),methodName});
        }};
        var methodParameters = new ArrayList<ArrayList<TypedMethodParameter>>(){{
            add(new ArrayList <>());
            add(new ArrayList <>(){{
                add(new TypedMethodParameter(ObjectType.IntType, "x"));
                add(new TypedMethodParameter(ObjectType.IntType, "y"));
            }});
        }};
        var blocks = new ArrayList<TypedBlock>();
        blocks.add(new TypedBlock(ObjectType.VoidType));
        blocks.add(new TypedBlock(ObjectType.IntType,
                new TypedLocalVarDeclaration(ObjectType.IntType, "t"),
                new TypedAssignStatement(new TypedLocalOrFieldVar(ObjectType.IntType, "t"),new TypedInt("-1")),
                new TypedIfElse(
                        new TypedBinary(new TypedLocalOrFieldVar(ObjectType.IntType, "x"),
                                new TypedLocalOrFieldVar(ObjectType.IntType, "y"),
                                Operators.GREATERTHAN, ObjectType.BoolType),
                        new TypedBlock(ObjectType.VoidType, new TypedAssignStatement(
                                new TypedLocalOrFieldVar(ObjectType.IntType, "t"), new TypedLocalOrFieldVar(ObjectType.IntType, "x"))),
                        new TypedBlock(ObjectType.IntType, new TypedIfElse(
                                new TypedBinary(new TypedLocalOrFieldVar(ObjectType.IntType, "x"),
                                        new TypedLocalOrFieldVar(ObjectType.IntType, "y"),
                                        Operators.EQUALS, ObjectType.BoolType),
                                new TypedBlock(ObjectType.IntType, new TypedReturn(new TypedLocalOrFieldVar(ObjectType.IntType, "y"),ObjectType.IntType)),
                                new TypedBlock(ObjectType.VoidType), ObjectType.IntType
                        )),
                        ObjectType.IntType
                ),
                new TypedReturn(new TypedLocalOrFieldVar(ObjectType.IntType, "t"), ObjectType.IntType)
                ));

        var methods = TypedProgramGenerator.getMethods(methodParams, blocks, methodParameters);

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), methods);
        return program;
    }
}
