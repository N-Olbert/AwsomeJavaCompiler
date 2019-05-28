package BytecodeTests;

import General.BytecodeLoader;
import common.*;
import org.junit.Test;
import org.objectweb.asm.ClassWriter;
import tastgenerator.expressions.TypedBinary;
import tastgenerator.expressions.TypedBoolean;
import tastgenerator.expressions.TypedInt;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedReturn;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ByteCodeBinaryTests
{
    private String className = "Binary";
    private String methodName = "test";
    private TypedMethodDeclaration ctor = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.VoidType, className, new ArrayList <>(), new TypedBlock(ObjectType.VoidType));
    @Test
    public void testEquals()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedInt("1"), new TypedInt("1"), Operators.EQUALS, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testLessThan()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedInt("1"), new TypedInt("2"), Operators.LESSTHAN, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGreaterThan()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedInt("2"), new TypedInt("1"), Operators.GREATERTHAN, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testLessOrEqualAsEqual()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedInt("1"), new TypedInt("1"), Operators.LESSOREQUAL, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testLessOrEqualAsLess()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedInt("1"), new TypedInt("2"), Operators.LESSOREQUAL, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGreaterThanOrEqualAsGreater()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedInt("12"), new TypedInt("1"), Operators.GREATEROREQUAL, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGreaterThanOrEqualAsEqual()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedInt("1"), new TypedInt("1"), Operators.GREATEROREQUAL, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNotEquals()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedInt("1"), new TypedInt("5"), Operators.NOTEQUALS, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testAnd()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedBoolean("true"), new TypedBoolean("true"), Operators.AND, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testOr()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedBoolean("false"), new TypedBoolean("true"), Operators.OR, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testXor()
    {
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.BoolType, methodName, new ArrayList <>(), new TypedBlock(ObjectType.BoolType,
                new TypedReturn(new TypedBinary(new TypedBoolean("false"), new TypedBoolean("true"), Operators.XOR, ObjectType.BoolType),ObjectType.BoolType)
        ));

        var program = TypedProgramGenerator.getProgram(className, new ArrayList <>(), new ArrayList <>() {{add(ctor);add(method);}});

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);
        List <ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var instance = loader.getConstructor(className).newInstance();

            var toTest = loader.getMethod(className, methodName);

            var result = toTest.invoke(instance);

            assertTrue((boolean) result);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
            fail();
        }
    }
}
