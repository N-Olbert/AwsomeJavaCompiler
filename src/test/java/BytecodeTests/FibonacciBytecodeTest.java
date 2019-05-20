package BytecodeTests;

import General.BytecodeLoader;
import common.*;
import org.junit.Test;
import tastgenerator.expressions.*;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedMethodParameter;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedIfElse;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedStatement;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FibonacciBytecodeTest
{
    @Test
    public void testFibonacciRecursive() throws Exception
    {
        var program = getFibonacciRecurisve();
        var byteCode = Global.getFactory().getBytecodeGenerator().generate(program);
        var loader = new BytecodeLoader(byteCode.get(0).toByteArray());
        var theClass = loader.findClass("Fibonacci");
        assertEquals(theClass.getDeclaredConstructors().length, 1);
        Constructor constructor = theClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var thing = constructor.newInstance(null);
        assertNotNull(thing);
        System.out.println(thing.toString());
        assertTrue(thing.toString().startsWith("Fibonacci@"));
        var method = theClass.getMethod("fibonacci", int.class);
        assertNotNull(method);
        var result = method.invoke(thing,11);
        assertEquals(89, result);
    }

    private TypedProgram getFibonacciRecurisve()
    {
        var className = "Fibonacci";
        var classType = ObjectType.getType(className);
        var methodName = "fibonacci";
        var methodParams = new ArrayList<TypedMethodParameter>();
        methodParams.add(new TypedMethodParameter(ObjectType.IntType, "n"));
        var condition = new TypedBinary(
                            new TypedLocalOrFieldVar(ObjectType.IntType, "n"),
                            new TypedInt("1"),
                            Operators.LESSOREQUAL, ObjectType.BoolType);
        var then = new TypedReturn(new TypedLocalOrFieldVar(ObjectType.IntType,"n"), ObjectType.IntType);
        var nMinusOne = new TypedBinary(new TypedLocalOrFieldVar(ObjectType.IntType, "n"),
                                        new TypedInt("1"), Operators.MINUS, ObjectType.IntType);
        var nMinusTwo = new TypedBinary(new TypedLocalOrFieldVar(ObjectType.IntType, "n"),
                                        new TypedInt("2"), Operators.MINUS, ObjectType.IntType);
        var otherwise =
           new TypedReturn(
                new TypedBinary(
                        new TypedMethodCallExpression(new TypedThis(classType), methodName, new ArrayList<>(){{add(nMinusOne);}}, ObjectType.IntType),
                        new TypedMethodCallExpression(new TypedThis(classType), methodName, new ArrayList<>(){{add(nMinusTwo);}}, ObjectType.IntType),
                        Operators.PLUS, ObjectType.IntType),
                ObjectType.IntType);

        var statements = new ArrayList<TypedStatement>();
        statements.add(new TypedIfElse(condition,
                                        new TypedBlock(new ArrayList<>(){{add(then);}}, ObjectType.IntType),
                                        new TypedBlock(new ArrayList<>(){{add(otherwise);}}, ObjectType.IntType), ObjectType.IntType));

        var methodBody = new TypedBlock(statements, ObjectType.IntType);
        var method = new TypedMethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.IntType,
                                         "fibonacci", methodParams, methodBody);

        var ctor = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE, Modifier.NONE, ObjectType.getType(className), className, new ArrayList<>(), new TypedBlock(new ArrayList<>(), ObjectType.VoidType));
        ctor.setObjectType(ObjectType.VoidType);
        var typedProgram = TypedProgramGenerator.getProgram(className, null,
                                                            new ArrayList<>(){{add(ctor);add(method);}});
        return typedProgram;
    }

}
