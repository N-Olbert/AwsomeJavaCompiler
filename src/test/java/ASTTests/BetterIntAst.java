package ASTTests;

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

public class BetterIntAst
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

        args = new ArrayList<>();
        args.add(
                new Binary(
                        new InstVar(new This(), "x"),
                        new InstVar(new LocalOrFieldVar("y"), "x"), Operators.LESSTHAN));

        var lessThan = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, classType, "LessThan",
                new ArrayList<>() {{ add(new MethodParameter(classType, "y"));}},
                new Block( new Return(new NewExpression(classType, args))));

        var methods = new ArrayList<MethodDeclaration>();
        methods.add(ctor1);
        methods.add(ctor2);
        methods.add(add);
        methods.add(subtract);
        methods.add(lessThan);

        return UntypedProgramGenerator.getProgram(className, fields, methods).getClasses().get(0);
    }

    public static TypedClass getTypedBetterIntClass()
    {
        var className = "BetterInt";
        var classType = ObjectType.getType(className);
        var fields = new ArrayList<TypedFieldDeclaration>();
        fields.add(new TypedFieldDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.IntType, "x"));

        var ctor1 = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "BetterInt",
                new ArrayList<>() {{add(new TypedMethodParameter(ObjectType.IntType, "x"));}},
                new TypedBlock(classType,
                        new TypedAssignStatement(new TypedInstVar(new TypedThis(classType), "x", ObjectType.IntType),
                        new TypedLocalOrFieldVar(ObjectType.IntType, "x"))));

        /**
        var ctor2 = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "BetterInt",
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

        args = new ArrayList<>();
        args.add(
                new Binary(
                        new InstVar(new This(), "x"),
                        new InstVar(new LocalOrFieldVar("y"), "x"), Operators.LESSTHAN));

        var lessThan = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, classType, "LessThan",
                new ArrayList<>() {{ add(new MethodParameter(classType, "y"));}},
                new Block( new Return(new NewExpression(classType, args))));

        var methods = new ArrayList<MethodDeclaration>();
        methods.add(ctor1);
        methods.add(ctor2);
        methods.add(add);
        methods.add(subtract);
        methods.add(lessThan);

        return UntypedProgramGenerator.getProgram(className, fields, methods).getClasses().get(0);
         **/
        return null;
    }
}
