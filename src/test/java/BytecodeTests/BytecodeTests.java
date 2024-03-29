package BytecodeTests;

import General.BytecodeLoader;
import common.AccessModifier;
import common.BytecodeGenerator;
import common.Factory;
import common.Global;
import common.Modifier;
import common.ObjectType;
import org.junit.Assert;
import org.junit.Test;
import org.objectweb.asm.ClassWriter;
import tastgenerator.expressions.TypedInstVar;
import tastgenerator.expressions.TypedInt;
import tastgenerator.expressions.TypedLocalOrFieldVar;
import tastgenerator.expressions.TypedThis;
import tastgenerator.generalelements.TypedClass;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedAssignStatement;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedStatement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BytecodeTests {
    public static void saveClass(byte[] bytes, String fileName) {
        File file = new File(fileName);

        try(FileOutputStream os = new FileOutputStream(file)) {
            os.write(bytes);
            os.flush();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testASTGenerationClassWithFields() {
        var className = "Point";
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        //Wird noch deutlich verbessert (generische Generierung).
        List<TypedFieldDeclaration> fields = new ArrayList<>();
        TypedFieldDeclaration field1 =
                new TypedFieldDeclaration(AccessModifier.PRIVATE, Modifier.NONE, ObjectType.IntType, "x");
        field1.setObjectType(ObjectType.IntType);
        TypedFieldDeclaration field2 =
                new TypedFieldDeclaration(AccessModifier.PRIVATE, Modifier.NONE, ObjectType.IntType, "y");
        field2.setObjectType(ObjectType.IntType);
        fields.add(field1);
        fields.add(field2);

        var testProgram = getProgram(className, fields, new ArrayList<>());

        List<ClassWriter> cws = byteCodeGen.generate(testProgram);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();
        BytecodeLoader loader = new BytecodeLoader(bytes);

        try {
            var extractedField = loader.getField(className, "x");
            assertEquals(extractedField.getType(), int.class);
        }
        catch(NoSuchFieldException e) {
            Assert.fail("Field \"x\" not found");
        }

        try {
            var extractedField = loader.getField(className, "y");
            assertEquals(extractedField.getType(), int.class);
        }
        catch(NoSuchFieldException e) {
            Assert.fail("Field \"y\" not found");
        }
    }

    @Test
    public void testASTClassGenerationWithMethod() {
        var methodName = "giveMeFive";
        var className = "TestReturn";

        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        List<TypedFieldDeclaration> fields = new ArrayList<>();
        var methods = new ArrayList<TypedMethodDeclaration>();
        var methodparameters = new ArrayList<TypedMethodParameter>();
        var statements = new ArrayList<TypedStatement>();
        statements.add(new TypedReturn(new TypedInt("5"), ObjectType.IntType));
        var typedBlock = new TypedBlock(statements, ObjectType.IntType);
        var typedMethod = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.STATIC,
                ObjectType.IntType, methodName, methodparameters, typedBlock);
        methods.add(typedMethod);

        var testProgram = getProgram(className, fields, methods);


        List<ClassWriter> cws = byteCodeGen.generate(testProgram);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] bytes = cws.get(0).toByteArray();


        BytecodeLoader loader = new BytecodeLoader(bytes);

        try {
            var Class = loader.findClass(className);
            var method = loader.getMethod(className, methodName);
            assertEquals(int.class, method.getReturnType());
            assertEquals(5, method.invoke(null));
        }
        catch(NoSuchMethodException e) {
            fail("Method: \"" + methodName + "\" not found");
        }
        catch(IllegalAccessException | InvocationTargetException e) {
            fail("Invoking Method: \"" + methodName + " \"");
        }
    }

    @Test
    public void testASTClassGenerationWithGetMethodOfParameter() {
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
        statements.add(new TypedReturn(new TypedLocalOrFieldVar(ObjectType.IntType, "x"), ObjectType.IntType));
        var typedBlock = new TypedBlock(statements, ObjectType.IntType);
        var typedMethod = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.STATIC,
                ObjectType.IntType, methodName, methodparameters, typedBlock);
        methods.add(typedMethod);

        var program = getProgram(className, fields, methods);
        List<ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] code = cws.get(0).toByteArray();
        saveClass(code, "target/class2.class");
        BytecodeLoader loader = new BytecodeLoader(code);

        try {
            var clazz = loader.findClass(className);
            assertNotNull(clazz);
            var method = loader.getMethod(className, methodName, int.class);
            assertEquals(int.class, method.getReturnType());
            assertEquals(5, method.invoke(null, 5));
            assertEquals(Integer.MAX_VALUE, method.invoke(null, Integer.MAX_VALUE));
            assertEquals(Integer.MIN_VALUE, method.invoke(null, Integer.MIN_VALUE));
            assertEquals(-5, method.invoke(null, -5));
            assertEquals(0, method.invoke(null, 0));
        }
        catch(NoSuchMethodException e) {
            fail("Method: \"" + methodName + "\" not found");
        }
        catch(IllegalAccessException | InvocationTargetException e) {
            fail("Invoking Method: \"" + methodName + " \"");
        }
    }

    @Test
    public void testASTClassGenerationWithParamConst() {
        var className = "TestConst";
        var methodName = "getX";
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        assertNotNull(byteCodeGen);

        List<TypedFieldDeclaration> fields = new ArrayList<>();
        var field = new TypedFieldDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.IntType, "x");
        fields.add(field);
        var methods = new ArrayList<TypedMethodDeclaration>();
        var constrParam = new ArrayList<TypedMethodParameter>();
        constrParam.add(new TypedMethodParameter(ObjectType.IntType, "x"));
        var constStatements = new ArrayList<TypedStatement>();
        constStatements.add(new TypedAssignStatement(
                new TypedInstVar(new TypedThis(ObjectType.getType(className)), "x", ObjectType.IntType),
                new TypedLocalOrFieldVar(ObjectType.IntType, "x")));
        var constr = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, className,
                constrParam, new TypedBlock(constStatements, ObjectType.VoidType));
        methods.add(constr);
        var statements = new ArrayList<TypedStatement>();
        statements.add(new TypedReturn(new TypedLocalOrFieldVar(ObjectType.IntType, "x"), ObjectType.IntType));
        var typedBlock = new TypedBlock(statements, ObjectType.IntType);
        var typedMethod = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                ObjectType.IntType, methodName, new ArrayList<>(), typedBlock);
        methods.add(typedMethod);

        var program = getProgram(className, fields, methods);
        List<ClassWriter> cws = byteCodeGen.generate(program);
        assertNotNull(cws);
        assertEquals(cws.size(), 1);
        byte[] code = cws.get(0).toByteArray();
        saveClass(code, "target/class3.class");
        BytecodeLoader loader = new BytecodeLoader(code);

        try {
            var clazz = loader.findClass(className);
            assertNotNull(clazz);
            var constructor = clazz.getConstructor(int.class);
            assertNotNull(clazz);
            var instance = constructor.newInstance(5);
            assertNotNull(instance);
            var method = loader.getMethod(className, methodName);
            assertEquals(int.class, method.getReturnType());
            assertEquals(5, method.invoke(instance));
        }
        catch(InstantiationException e) {
            fail("Constructor instantiation exception");
        }
        catch(NoSuchMethodException e) {
            fail("Method: \"" + methodName + "\" not found");
        }
        catch(IllegalAccessException | InvocationTargetException e) {
            fail("Invoking Method: \"" + methodName + " \"");
        }
    }

    private TypedProgram getProgram(String className, List<TypedFieldDeclaration> fields,
                                    List<TypedMethodDeclaration> methods) {
        List<TypedClass> classes = new ArrayList<>();
        TypedClass pointClass = new TypedClass(ObjectType.getType(className), fields, methods);
        classes.add(pointClass);
        var testProgram = new TypedProgram(classes);
        return testProgram;
    }
}
