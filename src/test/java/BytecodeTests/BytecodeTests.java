package BytecodeTests;

import astgenerator.generalelements.FieldDeclaration;
import common.*;
import org.junit.Assert;
import org.junit.Test;
import tastgenerator.generalelements.TypedClass;
import tastgenerator.generalelements.TypedFieldDeclaration;
import tastgenerator.generalelements.TypedProgram;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class BytecodeTests
{
    @Test
    public void testASTGeneration()
    {
        Factory factory = Global.getFactory();
        Assert.assertNotNull(factory);
        BytecodeGenerator byteCodeGen = factory.getBytecodeGenerator();
        Assert.assertNotNull(byteCodeGen);

        //Wird noch deutlich verbessert (generische Generierung).
        TypedProgram testProgram = new TypedProgram();
        List<TypedClass> classes = new ArrayList<TypedClass>();
        List<TypedFieldDeclaration> fields = new ArrayList<TypedFieldDeclaration>();
        TypedFieldDeclaration field1 = new TypedFieldDeclaration(AccessModifier.PRIVATE, Modifier.NONE, ObjectType.IntType, "x");
        field1.setObjectType(ObjectType.IntType);
        TypedFieldDeclaration field2 = new TypedFieldDeclaration(AccessModifier.PRIVATE, Modifier.NONE,ObjectType.IntType, "y");
        field2.setObjectType(ObjectType.IntType);
        fields.add(field1);
        fields.add(field2);
        TypedClass pointClass = new TypedClass(new ObjectType("Point"), fields, null);
        classes.add(pointClass);
        testProgram.setClasses(classes);

        OutputStream code = byteCodeGen.getByteCode(testProgram);
        Assert.assertNotNull(code);

        //TESTS folgen noch.
        Assert.assertEquals(true, true);
    }
}
