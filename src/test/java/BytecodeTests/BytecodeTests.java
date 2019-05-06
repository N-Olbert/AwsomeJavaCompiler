package BytecodeTests;

import General.BytecodeLoader;
import astgenerator.generalelements.FieldDeclaration;
import common.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import org.objectweb.asm.ClassWriter;
import tastgenerator.expressions.TypedInt;
import tastgenerator.generalelements.*;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedStatement;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class BytecodeTests
{
    @Test
    public void testASTGenerationClassWithFields()
    {
        var className = "Point";
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        //Wird noch deutlich verbessert (generische Generierung).
        List<TypedFieldDeclaration> fields = new ArrayList<>();
        TypedFieldDeclaration field1 = new TypedFieldDeclaration(AccessModifier.PRIVATE, Modifier.NONE, ObjectType.IntType, "x");
        field1.setObjectType(ObjectType.IntType);
        TypedFieldDeclaration field2 = new TypedFieldDeclaration(AccessModifier.PRIVATE, Modifier.NONE, ObjectType.IntType, "y");
        field2.setObjectType(ObjectType.IntType);
        fields.add(field1);
        fields.add(field2);

        var testProgram = getProgram(className, fields, new ArrayList <>());

        List<ClassWriter> cws = byteCodeGen.generate(testProgram);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var extractedField = loader.getField(className, "x");
            assertEquals(extractedField.getType(), int.class);
        }
        catch (NoSuchFieldException e)
        {
            Assert.fail("Field \"x\" not found");
        }

        try
        {
            var extractedField = loader.getField(className, "y");
            assertEquals(extractedField.getType(), int.class);
        }
        catch (NoSuchFieldException e)
        {
            Assert.fail("Field \"y\" not found");
        }
    }

    //@Test Not implemented yet
    public void testASTClassGenerationWithMethod()
    {
        var methodName = "TestGetInt";
        var className = "TestReturn";

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        List<TypedFieldDeclaration> fields = new ArrayList<>();
        var methods = new ArrayList<TypedMethodDeclaration>();
        var methodparameters = new ArrayList<TypedMethodParameter>();
        var statements = new ArrayList<TypedStatement>();
        statements.add(new TypedReturn(new TypedInt("5")));
        var typedBlock = new TypedBlock(statements);
        var typedMethod = new TypedMethodDeclaration(AccessModifier.PUBLIC,Modifier.NONE,
                ObjectType.IntType, methodName, methodparameters, typedBlock);
        methods.add(typedMethod);

        var testProgram = getProgram(className, fields, methods);


        List<ClassWriter> cws = byteCodeGen.generate(testProgram);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try
        {
            var Class = loader.findClass(className);
            var method = loader.getMethod(className, methodName);
            assertEquals(int.class, method.getReturnType());
            assertEquals(5, method.invoke(Class));
        }
        catch (NoSuchMethodException e)
        {
            fail("Method: \"" + methodName + "\" not found");
        }
        catch (IllegalAccessException | InvocationTargetException e)
        {
            fail("Invoking Method: \""+methodName + " \"");
        }
    }

    //@Test Not implemented yet
    public void testASTClassGenerationWithGetMethodOfParameter()
    {
        var className = "TestSimpleStatement";
        var methodName = "ReturnParameter";
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        List<TypedFieldDeclaration> fields = new ArrayList<>();
        var methods = new ArrayList<TypedMethodDeclaration>();
        var methodparameters = new ArrayList<TypedMethodParameter>();
        methodparameters.add(new TypedMethodParameter(ObjectType.IntType, "x"));
        var statements = new ArrayList<TypedStatement>();
        statements.add(new TypedReturn(new TypedInt(methodparameters.get(0).getName())));
        var typedBlock = new TypedBlock(statements);
        var typedMethod = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.IntType, methodName, methodparameters, typedBlock);
        methods.add(typedMethod);

        var program = getProgram(className, fields, methods);
        List<ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] code = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(code);

        try
        {
            var Class = loader.findClass(className);
            var method = loader.getMethod(className, methodName);
            assertEquals(int.class, method.getReturnType());
            assertEquals(5, method.invoke(Class, 5));
            assertEquals(0, Class.getFields().length);
            assertEquals(1, Class.getMethods().length);
        }
        catch (NoSuchMethodException e)
        {
            fail("Method: \"" + methodName + "\" not found");
        }
        catch (IllegalAccessException | InvocationTargetException e)
        {
            fail("Invoking Method: \""+methodName + " \"");
        }
    }


    private TypedProgram getProgram(String className, List<TypedFieldDeclaration> fields ,List<TypedMethodDeclaration> methods)
    {
        TypedProgram testProgram = new TypedProgram();
        List<TypedClass> classes = new ArrayList<>();
        TypedClass pointClass = new TypedClass(ObjectType.getType(className), fields, methods);
        classes.add(pointClass);
        testProgram.setClasses(classes);
        return testProgram;
    }
}
