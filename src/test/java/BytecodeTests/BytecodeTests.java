package BytecodeTests;

import common.BytecodeGenerator;
import common.Factory;
import common.Global;
import org.junit.Assert;
import org.junit.Test;
import tastgenerator.generalelements.Class;
import tastgenerator.generalelements.FieldDeclaration;
import tastgenerator.generalelements.ObjectType;
import tastgenerator.generalelements.Program;

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
        Program testProgram = new Program();
        List<Class> classes = new ArrayList<Class>();
        List<FieldDeclaration> fields = new ArrayList<FieldDeclaration>();
        FieldDeclaration field1 = new FieldDeclaration(ObjectType.IntType, "x");
        field1.setObjectType(ObjectType.IntType);
        FieldDeclaration field2 = new FieldDeclaration(ObjectType.IntType, "y");
        field2.setObjectType(ObjectType.IntType);
        fields.add(field1);
        fields.add(field2);
        Class pointClass = new Class(new ObjectType("Point"), fields, null);
        classes.add(pointClass);
        testProgram.setClasses(classes);

        OutputStream code = byteCodeGen.getByteCode(testProgram);
        Assert.assertNotNull(code);

        //TESTS folgen noch.
        Assert.assertEquals(true, true);
    }
}
