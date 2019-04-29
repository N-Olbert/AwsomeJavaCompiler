package TypedASTTests;

import common.Factory;
import common.Global;
import common.TypedASTGenerator;
import org.junit.Assert;
import org.junit.Test;
import tastgenerator.generalelements.Class;
import tastgenerator.generalelements.FieldDeclaration;
import tastgenerator.generalelements.ObjectType;
import tastgenerator.generalelements.Program;

import java.util.ArrayList;
import java.util.List;

public class TypedASTBaseTests
{
    @Test
    public void testASTGeneration()
    {
        Factory factory = Global.getFactory();
        Assert.assertNotNull(factory);
        TypedASTGenerator astGen = factory.getTypedAstGenerator();
        Assert.assertNotNull(astGen);

        //Wird noch deutlich verbessert (generische Generierung).
        Program testProgram = new Program();
        List<Class> classes = new ArrayList<Class>();
        List<FieldDeclaration> fields = new ArrayList<FieldDeclaration>();
        FieldDeclaration field1 = new FieldDeclaration(ObjectType.IntType, "x");
        FieldDeclaration field2 = new FieldDeclaration(ObjectType.IntType, "y");
        fields.add(field1);
        fields.add(field2);
        Class pointClass = new Class(new ObjectType("Point"), fields, null);
        classes.add(pointClass);
        testProgram.setClasses(classes);

        Program ast = astGen.getTypedProgram(testProgram);
        Assert.assertNotNull(ast);

        //Korrekt wäre irgendwas in der Art, wird noch implementiert
        // Program([(CLASS("Test",[FD(INT, INT, x), FD(INT, INT, Y)],[])])
        Assert.assertEquals(true, true);
    }
}
