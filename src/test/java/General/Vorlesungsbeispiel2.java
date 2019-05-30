package General;

import astgenerator.expressions.InstVar;
import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.expressions.MethodCallExpression;
import astgenerator.expressions.NewExpression;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.Block;
import astgenerator.statements.LocalVarDeclaration;
import astgenerator.statements.Return;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.*;
import tastgenerator.statements.TypedAssignStatement;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedLocalVarDeclaration;
import tastgenerator.statements.TypedReturn;

import java.util.ArrayList;

public class Vorlesungsbeispiel2
{
    /**
     * Class Cl1 {
     *     char m1() {
     *         int b;
     *         Cl2 x = new Cl2();
     *         return x.m2(x.v, b);
     *     }
     * }
     *
     * Class Cl2 {
     *     Cl3 v;
     *     char m2(Cl3 v, int w) {
     *         return v.y;
     *     }
     * }
     *
     * Class Cl3 {
     *     char y;
     * }
     */

    public static UntypedProgram getVorlesungsbeispiel2Program()
    {
        var c1 = "Cl1";
        var c2 = "Cl2";
        var c3 = "Cl3";
        var ctor = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                c1, new ArrayList<>(), new Block());
        var m1 = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.CharType,
                "m1", new ArrayList<>(),
                new Block(
                        new LocalVarDeclaration(ObjectType.IntType, "b"),
                        new LocalVarDeclaration(ObjectType.getType(c2), "x"),
                        new AssignStatement(new LocalOrFieldVar("x"), new NewExpression(ObjectType.getType(c2), new ArrayList<>())),
                        new Return(
                                new MethodCallExpression(new LocalOrFieldVar("x"), "m2",
                                        new ArrayList<>(){{
                                            add(new InstVar(new LocalOrFieldVar("x"), "v"));
                                            add(new LocalOrFieldVar("b"));
                                        }})
                        )));
        var class1 = new Class(ObjectType.getType(c1), new ArrayList<>(),
                new ArrayList<>(){{ add(ctor); add(m1); }});

        var ctor2 = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                c2, new ArrayList<>(), new Block());
        var fields2 = new ArrayList<FieldDeclaration>();
        fields2.add(new FieldDeclaration(ObjectType.getType(c3), "v"));

        var m2 = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.CharType,
                "m2", new ArrayList<>(){{add(new MethodParameter(ObjectType.getType(c3), "v"));
                                               add(new MethodParameter(ObjectType.IntType, "w"));}},
                new Block(
                        new Return(new InstVar(new LocalOrFieldVar("v"), "y"))
                ));

        var class2 = new Class(ObjectType.getType(c2), fields2,
                new ArrayList<>(){{ add(ctor2); add(m2); }});

        var ctor3 = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                c3, new ArrayList<>(), new Block());
        var fields3 = new ArrayList<FieldDeclaration>();
        fields3.add(new FieldDeclaration(ObjectType.CharType, "y"));
        var class3 = new Class(ObjectType.getType(c3), fields3,
                new ArrayList<>(){{ add(ctor3); }});

        var prog = new UntypedProgram();
        prog.getClasses().add(class1);
        prog.getClasses().add(class2);
        prog.getClasses().add(class3);
        return prog;
    }

    public static TypedProgram getVorlesungsbeispiel2TypedProgram()
    {
        var c1 = "Cl1";
        var c2 = "Cl2";
        var c2T = ObjectType.getType(c2);
        var c3 = "Cl3";
        var c3T = ObjectType.getType(c3);
        var ctor = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                c1, new ArrayList<>(), new TypedBlock(ObjectType.VoidType));
        var m1 = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.CharType,
                "m1", new ArrayList<>(),
                new TypedBlock(
                        ObjectType.CharType,
                        new TypedLocalVarDeclaration(ObjectType.IntType, "b"),
                        new TypedLocalVarDeclaration(c2T, "x"),
                        new TypedAssignStatement(
                                new TypedLocalOrFieldVar(c2T, "x"),
                                new TypedNewExpression(c2T, new ArrayList<>())),
                        new TypedReturn(
                                new TypedMethodCallExpression(
                                        new TypedLocalOrFieldVar(c2T, "x"), "m2",
                                        new ArrayList<>(){{
                                            add(new TypedInstVar(new TypedLocalOrFieldVar(c2T, "x"), "v", c3T));
                                            add(new TypedLocalOrFieldVar(ObjectType.IntType, "b"));
                                        }}, ObjectType.CharType),
                                ObjectType.CharType
                        )));
        var class1 = new TypedClass(ObjectType.getType(c1), new ArrayList<>(),
                new ArrayList<>(){{ add(ctor); add(m1); }});

        var ctor2 = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                c2, new ArrayList<>(), new TypedBlock(ObjectType.VoidType));
        var fields2 = new ArrayList<TypedFieldDeclaration>();
        fields2.add(new TypedFieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.getType(c3), "v"));

        var m2 = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.CharType,
                "m2", new ArrayList<>(){{add(new TypedMethodParameter(ObjectType.getType(c3), "v"));
            add(new TypedMethodParameter(ObjectType.IntType, "w"));}},
                new TypedBlock(ObjectType.CharType,
                        new TypedReturn(
                                new TypedInstVar(
                                        new TypedLocalOrFieldVar(c3T, "v"), "y", ObjectType.CharType),
                                ObjectType.CharType)
                ));

        var class2 = new TypedClass(ObjectType.getType(c2), fields2,
                new ArrayList<>(){{ add(ctor2); add(m2); }});

        var ctor3 = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType,
                c3, new ArrayList<>(), new TypedBlock(ObjectType.VoidType));
        var fields3 = new ArrayList<TypedFieldDeclaration>();
        fields3.add(new TypedFieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.CharType, "y"));
        var class3 = new TypedClass(ObjectType.getType(c3), fields3,
                new ArrayList<>(){{ add(ctor3); }});

        var prog = new TypedProgram(new ArrayList<>());
        prog.getClasses().add(class1);
        prog.getClasses().add(class2);
        prog.getClasses().add(class3);
        return prog;
    }
}
