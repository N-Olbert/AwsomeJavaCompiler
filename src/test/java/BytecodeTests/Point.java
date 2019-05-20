package BytecodeTests;

import common.AccessModifier;
import common.BytecodeGenerator;
import common.Factory;
import common.Global;
import common.Modifier;
import common.ObjectType;
import tastgenerator.expressions.TypedInstVar;
import tastgenerator.expressions.TypedLocalOrFieldVar;
import tastgenerator.expressions.TypedThis;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedAssignStatement;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedStatement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

class Point {
    static final String methodNameGetX = "testGetX";
    static final String methodNameSetX = "testSetX";
    static final String methodNameGetY = "testGetY";
    static final String methodNameSetY = "testSetY";
    static final String constructorName = "PointerTest";
    static final String className = "PointerTest";

    private Point() {
    }

    static TypedProgram getPointWithGetSetContstructor() {
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        List<TypedFieldDeclaration> fields = new ArrayList<>() {{
            add(new TypedFieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType, "x"));
            add(new TypedFieldDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.IntType, "y"));
        }};
        var methodParams = new ArrayList<String[]>();
        methodParams.add(new String[] {ObjectType.VoidType.getName(), methodNameSetX});
        methodParams.add(new String[] {ObjectType.IntType.getName(), methodNameGetX});
        methodParams.add(new String[] {ObjectType.VoidType.getName(), methodNameSetY});
        methodParams.add(new String[] {ObjectType.IntType.getName(), methodNameGetY});
        methodParams.add(new String[] {ObjectType.VoidType.getName(), constructorName});
        var blocks = new ArrayList<TypedBlock>();
        var typedStatements = new ArrayList<TypedStatement>();
        typedStatements
                .add(new TypedAssignStatement(
                        new TypedInstVar(new TypedThis(ObjectType.getType(className)), "x", ObjectType.IntType),
                        new TypedLocalOrFieldVar(ObjectType.IntType, "x")));
        blocks.add(new TypedBlock(typedStatements, ObjectType.IntType));

        var typedStatements1 = new ArrayList<TypedStatement>();
        typedStatements1.add(new TypedReturn(
                new TypedInstVar(new TypedThis(ObjectType.getType(className)), "x", ObjectType.IntType),
                ObjectType.IntType));
        blocks.add(new TypedBlock(typedStatements1, ObjectType.IntType));
        var typedStatements2 = new ArrayList<TypedStatement>();
        typedStatements2
                .add(new TypedAssignStatement(
                        new TypedInstVar(new TypedThis(ObjectType.getType(className)), "y", ObjectType.IntType),
                        new TypedLocalOrFieldVar(ObjectType.IntType, "y")));
        blocks.add(new TypedBlock(typedStatements2, ObjectType.IntType));
        var typedStatements3 = new ArrayList<TypedStatement>();
        typedStatements3.add(new TypedReturn(
                new TypedInstVar(new TypedThis(ObjectType.getType(className)), "y", ObjectType.IntType),
                ObjectType.IntType));
        blocks.add(new TypedBlock(typedStatements3, ObjectType.IntType));
        var typedStatements4 = new ArrayList<TypedStatement>();
        typedStatements4
                .add(new TypedAssignStatement(
                        new TypedInstVar(new TypedThis(ObjectType.getType(className)), "x", ObjectType.IntType),
                        new TypedLocalOrFieldVar(ObjectType.IntType, "x")));
        typedStatements4
                .add(new TypedAssignStatement(
                        new TypedInstVar(new TypedThis(ObjectType.getType(className)), "y", ObjectType.IntType),
                        new TypedLocalOrFieldVar(ObjectType.IntType, "y")));
        blocks.add(new TypedBlock(typedStatements4, ObjectType.IntType));

        var methodParameters = new ArrayList<ArrayList<TypedMethodParameter>>();
        methodParameters.add(new ArrayList<>() {{
            add(new TypedMethodParameter(ObjectType.IntType, "x"));
        }});
        methodParameters.add(new ArrayList<>());
        methodParameters.add(new ArrayList<>() {{
            add(new TypedMethodParameter(ObjectType.IntType, "y"));
        }});
        methodParameters.add(new ArrayList<>());
        methodParameters.add(new ArrayList<>() {{
            add(new TypedMethodParameter(ObjectType.IntType, "x"));
            add(new TypedMethodParameter(ObjectType.IntType, "y"));
        }});
        var methods = TypedProgramGenerator.getMethods(methodParams, blocks, methodParameters);


        return TypedProgramGenerator.getProgram(className, fields, methods);
    }
}
