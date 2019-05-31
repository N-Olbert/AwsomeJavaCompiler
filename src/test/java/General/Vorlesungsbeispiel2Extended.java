package General;

import astgenerator.expressions.*;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.*;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import common.Operators;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.*;
import tastgenerator.statements.*;

import java.util.ArrayList;

public class Vorlesungsbeispiel2Extended
{
    public static UntypedProgram getVorlesungsbeispiel2Extended1Program()
    {
        var className = "Cl4";
        var baseProg = Vorlesungsbeispiel2.getVorlesungsbeispiel2Program();
        var method = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE,  Modifier.NONE, ObjectType.JObjectType,
                "testTypeObjectReturn",
                new ArrayList<>(){{
                    add(new MethodParameter(ObjectType.getType("Cl3"), "a"));
                    add(new MethodParameter(ObjectType.getType("Cl2"), "b"));}},
                new Block(
                        new IfElse(
                                new Binary(new LocalOrFieldVar("a"), new JNull(), Operators.EQUALS),
                                new Block(
                                        new Return(new LocalOrFieldVar("b"))
                                ),
                                new Block(
                                        new Return(new LocalOrFieldVar("a"))
                                ))
                ));

        var class4 = new Class(ObjectType.getType(className), new ArrayList<>(),
                new ArrayList<>(){{add(method);}});
        baseProg.getClasses().add(class4);
        return baseProg;
    }

    public static TypedProgram getVorlesungsbeispiel2Extended1TypedProgram()
    {
        var className = "Cl4";
        var baseProg = Vorlesungsbeispiel2.getVorlesungsbeispiel2TypedProgram();
        var method = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE,  Modifier.NONE, ObjectType.JObjectType,
                "testTypeObjectReturn",
                new ArrayList<>(){{
                    add(new TypedMethodParameter(ObjectType.getType("Cl3"), "a"));
                    add(new TypedMethodParameter(ObjectType.getType("Cl2"), "b"));}},
                new TypedBlock(
                        ObjectType.JObjectType,
                        new TypedIfElse(
                                new TypedBinary(
                                        new TypedLocalOrFieldVar(ObjectType.getType("Cl3"), "a"),
                                        new TypedNull(),
                                        Operators.EQUALS,
                                        ObjectType.BoolType),
                                new TypedBlock(ObjectType.getType("Cl2"),
                                        new TypedReturn(
                                                new TypedLocalOrFieldVar(ObjectType.getType("Cl2"), "b"),
                                                ObjectType.getType("Cl2"))
                                ),
                                new TypedBlock(ObjectType.getType("Cl3"),
                                        new TypedReturn(
                                                new TypedLocalOrFieldVar(ObjectType.getType("Cl3"), "a"),
                                                ObjectType.getType("Cl3"))
                                ), ObjectType.JObjectType)
                ));

        var class4 = new TypedClass(ObjectType.getType(className), new ArrayList<>(),
                new ArrayList<>(){{add(method);}});
        baseProg.getClasses().add(class4);
        return baseProg;
    }

    public static UntypedProgram getVorlesungsbeispiel2Extended2Program()
    {
        var className = "Cl5";
        var baseProg = Vorlesungsbeispiel2.getVorlesungsbeispiel2Program();
        var method = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE,  Modifier.NONE, ObjectType.IntType,
                "testWideningReturn",
                new ArrayList<>(){{
                    add(new MethodParameter(ObjectType.IntType, "i"));
                    add(new MethodParameter(ObjectType.CharType, "x"));}},
                new Block(
                        new IfElse(
                                new Binary(new LocalOrFieldVar("i"), new JInteger("5"), Operators.LESSTHAN),
                                new Block(
                                        new Return(new LocalOrFieldVar("i"))
                                ),
                                new Block(
                                        new Return(new LocalOrFieldVar("x"))
                                ))
                ));

        var class4 = new Class(ObjectType.getType(className), new ArrayList<>(),
                new ArrayList<>(){{add(method);}});
        baseProg.getClasses().add(class4);
        return baseProg;
    }

    public static TypedProgram getVorlesungsbeispiel2Extended2TypedProgram()
    {
        var className = "Cl5";
        var baseProg = Vorlesungsbeispiel2.getVorlesungsbeispiel2TypedProgram();
        var method = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE,  Modifier.NONE, ObjectType.IntType,
                "testWideningReturn",
                new ArrayList<>(){{
                    add(new TypedMethodParameter(ObjectType.IntType, "i"));
                    add(new TypedMethodParameter(ObjectType.CharType, "x"));}},
                new TypedBlock(
                        ObjectType.IntType,
                        new TypedIfElse(
                                new TypedBinary(
                                        new TypedLocalOrFieldVar(ObjectType.IntType, "i"),
                                        new TypedInt("5"),
                                        Operators.LESSTHAN,
                                        ObjectType.BoolType),
                                new TypedBlock(ObjectType.IntType,
                                        new TypedReturn(
                                                new TypedLocalOrFieldVar(ObjectType.IntType, "i"),
                                                ObjectType.IntType)
                                ),
                                new TypedBlock(ObjectType.CharType,
                                        new TypedReturn(
                                                new TypedLocalOrFieldVar(ObjectType.CharType, "x"),
                                                ObjectType.CharType)
                                ), ObjectType.IntType)
                ));

        var class4 = new TypedClass(ObjectType.getType(className), new ArrayList<>(),
                new ArrayList<>(){{add(method);}});
        baseProg.getClasses().add(class4);
        return baseProg;
    }
}