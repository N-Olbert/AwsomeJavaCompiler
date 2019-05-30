package General;

import BytecodeTests.TypedProgramGenerator;
import TypedASTTests.UntypedProgramGenerator;
import astgenerator.expressions.*;
import astgenerator.generalelements.FieldDeclaration;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.Block;
import astgenerator.statements.Return;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import common.Operators;
import tastgenerator.expressions.TypedBinary;
import tastgenerator.expressions.TypedLocalOrFieldVar;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedReturn;

import java.util.ArrayList;

public class Vorlesungsbeispiel1
{
    public static UntypedProgram getVorlesungsbeispiel1Program()
    {
        /**
         * class Klassenname {
         *     int v;
         *     int methode (int x) {
         *         return v + x;
         *     }
         * }
         */
        var className = "Klassenname";
        var fields = new ArrayList<FieldDeclaration>();
        fields.add(new FieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType, "v"));

        var ctor = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType, className,
                                         new ArrayList<>(), new Block());
        var method = new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType, "methode",
                                            new ArrayList<>() {{add(new MethodParameter(ObjectType.IntType, "x"));}},
                                            new Block(
                                                    new Return(
                                                            new Binary(
                                                                    new LocalOrFieldVar("v"),
                                                                    new LocalOrFieldVar("x"),
                                                                    Operators.PLUS))));
        var methods = new ArrayList<MethodDeclaration>();
        methods.add(ctor);
        methods.add(method);

        return UntypedProgramGenerator.getProgram(className, fields, methods);
    }

    public static TypedProgram getVorlesungsbeispiel1TypedProgram()
    {
        /**
         * class Klassenname {
         *     int v;
         *     int methode (int x) {
         *         return v + x;
         *     }
         * }
         */
        var className = "Klassenname";
        var fields = new ArrayList<TypedFieldDeclaration>();
        fields.add(new TypedFieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType, "v"));

        var ctor = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE,
                                              ObjectType.VoidType, className,
                                              new ArrayList<>(),
                                              new TypedBlock(new ArrayList<>(), ObjectType.VoidType));
        var method = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType,
                                                "methode",
                                                new ArrayList<>() {{add(new TypedMethodParameter(ObjectType.IntType, "x"));}},
                                                new TypedBlock(ObjectType.IntType,
                                                        new TypedReturn(
                                                                new TypedBinary(
                                                                        new TypedLocalOrFieldVar(ObjectType.IntType, "v"),
                                                                        new TypedLocalOrFieldVar(ObjectType.IntType, "x"),
                                                                        Operators.PLUS, ObjectType.IntType),
                                                                ObjectType.IntType)));
        var methods = new ArrayList<TypedMethodDeclaration>();
        methods.add(ctor);
        methods.add(method);

        return TypedProgramGenerator.getProgram(className, fields, methods);
    }
}
