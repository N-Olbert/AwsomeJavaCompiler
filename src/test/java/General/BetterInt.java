package General;

import TypedASTTests.UntypedProgramGenerator;
import astgenerator.expressions.*;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.Block;
import astgenerator.statements.Return;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import common.Operators;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.*;
import tastgenerator.statements.*;

import java.util.ArrayList;
import java.util.List;

public class BetterInt
{
    public static Class getBetterIntClass()
    {
        var className = "BetterInt";
        var classType = ObjectType.getType(className);
        var fields = new ArrayList<FieldDeclaration>();
        fields.add(new FieldDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.IntType, "x"));

        var ctor1 = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "BetterInt",
                new ArrayList<>() {{add(new MethodParameter(ObjectType.IntType, "x"));}},
                new Block(new AssignStatement(new InstVar(new This(), "x"), new LocalOrFieldVar("x"))));

        var ctor2 = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "BetterInt",
                new ArrayList<>(),
                new Block(new AssignStatement(new InstVar(new This(), "x"), new JInteger("0"))));

        List<Expression> args = new ArrayList<>();
        args.add(
                new Binary(
                        new InstVar(new This(), "x"),
                        new InstVar(new LocalOrFieldVar("y"), "x"), Operators.PLUS));

        var add = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, classType, "Add",
                new ArrayList<>() {{ add(new MethodParameter(classType, "y"));}},
                new Block( new Return(new NewExpression(classType, args))));

        args = new ArrayList<>();
        args.add(
                new Binary(
                        new InstVar(new This(), "x"),
                        new InstVar(new LocalOrFieldVar("y"), "x"), Operators.MINUS));

        var subtract = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, classType, "Subtract",
                new ArrayList<>() {{ add(new MethodParameter(classType, "y"));}},
                new Block( new Return(new NewExpression(classType, args))));

        var lessThan = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.BoolType, "LessThan",
                new ArrayList<>() {{ add(new MethodParameter(classType, "y"));}},
                new Block( new Return(new Binary(
                        new InstVar(new This(), "x"),
                        new InstVar(new LocalOrFieldVar("y"), "x"), Operators.LESSTHAN))));

        var methods = new ArrayList<MethodDeclaration>();
        methods.add(ctor1);
        methods.add(ctor2);
        methods.add(add);
        methods.add(subtract);
        methods.add(lessThan);

        return UntypedProgramGenerator.getProgram(className, fields, methods).getClasses().get(0);
    }

    public static UntypedProgram getBetterIntProgram()
    {
        var program = new UntypedProgram();
        program.getClasses().add(getBetterIntClass());
        return program;
    }

    public static TypedClass getTypedBetterIntClass()
    {
        var className = "BetterInt";
        var classType = ObjectType.getType(className);
        var fields = new ArrayList<TypedFieldDeclaration>();
        fields.add(new TypedFieldDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.IntType, "x"));

        var ctor1 = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "BetterInt",
                new ArrayList<>() {{add(new TypedMethodParameter(ObjectType.IntType, "x"));}},
                new TypedBlock(ObjectType.VoidType,
                        new TypedAssignStatement(new TypedInstVar(new TypedThis(classType), "x", ObjectType.IntType),
                        new TypedLocalOrFieldVar(ObjectType.IntType, "x"))));

        var ctor2 = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "BetterInt",
                new ArrayList<>(),
                new TypedBlock(ObjectType.VoidType,
                               new TypedAssignStatement(new TypedInstVar(new TypedThis(classType), "x", ObjectType.IntType), new TypedInt("0"))));

        List<TypedExpression> args = new ArrayList<>();
        args.add(
                new TypedBinary(
                        new TypedInstVar(new TypedThis(classType), "x", ObjectType.IntType),
                        new TypedInstVar(new TypedLocalOrFieldVar(classType,"y"), "x", ObjectType.IntType),
                        Operators.PLUS, ObjectType.IntType));

        var add = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, classType, "Add",
                new ArrayList<>() {{ add(new TypedMethodParameter(classType, "y"));}},
                new TypedBlock(classType, new TypedReturn(new TypedNewExpression(classType, args), classType)));

        args = new ArrayList<>();
        args.add(
                new TypedBinary(
                        new TypedInstVar(new TypedThis(classType), "x", ObjectType.IntType),
                        new TypedInstVar(new TypedLocalOrFieldVar(classType,"y"), "x", ObjectType.IntType),
                        Operators.MINUS, ObjectType.IntType));

        var subtract = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, classType, "Subtract",
                new ArrayList<>() {{ add(new TypedMethodParameter(classType, "y"));}},
                new TypedBlock(classType, new TypedReturn(new TypedNewExpression(classType, args), classType)));

        args = new ArrayList<>();
        args.add(
                new TypedBinary(
                        new TypedInstVar(new TypedThis(classType), "x", classType),
                        new TypedInstVar(new TypedLocalOrFieldVar(classType, "y"), "x", ObjectType.IntType),
                        Operators.LESSTHAN, ObjectType.BoolType));

        var lessThan = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.BoolType, "LessThan",
                new ArrayList<>() {{ add(new TypedMethodParameter(classType, "y"));}},
                new TypedBlock(ObjectType.BoolType, new TypedReturn(new TypedBinary(
                        new TypedInstVar(new TypedThis(classType), "x", ObjectType.IntType),
                        new TypedInstVar(new TypedLocalOrFieldVar(classType, "y"), "x", ObjectType.IntType),
                        Operators.LESSTHAN, ObjectType.BoolType), ObjectType.BoolType)));

        var methods = new ArrayList<TypedMethodDeclaration>();
        methods.add(ctor1);
        methods.add(ctor2);
        methods.add(add);
        methods.add(subtract);
        methods.add(lessThan);

        return new TypedClass(classType, fields, methods);
    }

    public static TypedProgram getTypedBetterIntProgram()
    {
        var expected = new TypedProgram(new ArrayList<>());
        expected.getClasses().add(BetterInt.getTypedBetterIntClass());
        return expected;
    }
}
