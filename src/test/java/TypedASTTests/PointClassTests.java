package TypedASTTests;

import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.Block;
import astgenerator.statements.Return;
import common.*;
import org.junit.Test;
import tastgenerator.generalelements.TypedProgram;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class PointClassTests
{
    @Test
    public void testPointClassBase()
    {
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        TypedASTGenerator astGen = factory.getTypedAstGenerator();
        assertNotNull(astGen);
        var typed = astGen.getTypedProgram(getBasePointClass());
        assertTrue(assertDefaultPointClass(typed));
    }

    @Test
    public void testPointClassGetSet()
    {
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        TypedASTGenerator astGen = factory.getTypedAstGenerator();
        assertNotNull(astGen);
        var typed = astGen.getTypedProgram(getBasePointClass());
        assertTrue(assertDefaultPointClass(typed));
    }
    private UntypedProgram getBasePointClass()
    {
        var className = "Point";
        var testProgram = new UntypedProgram();
        var classes = new ArrayList<Class>();
        var fields = new ArrayList<FieldDeclaration>();
        var field1 = new FieldDeclaration(ObjectType.IntType, "x");
        var field2 = new FieldDeclaration(ObjectType.IntType, "y");
        fields.add(field1);
        fields.add(field2);
        var pointClass = new Class(ObjectType.getType(className), fields, new ArrayList<>());
        classes.add(pointClass);
        testProgram.setClasses(classes);
        return testProgram;
    }

    private UntypedProgram getPointClassWithGetterSetter()
    {
        var baseClass = getBasePointClass();
        var methods = baseClass.getClasses().get(1).getMethods();
        //var returnStatement = new Return(new LocalOrFiel)
        //var block = new Block()

        MethodDeclaration getX;

        return baseClass;
    }

    private boolean assertDefaultPointClass(TypedProgram typedProgram)
    {
        assertNotNull(typedProgram);
        assertEquals(typedProgram.getClasses().size(), 1);
        var typedPointClass = typedProgram.getClasses().get(1);
        assertEquals(typedProgram.getObjectType(), ObjectType.getType("Point"));
        var typedFields = typedPointClass.getFields();
        assertEquals(typedFields.size(), 2);
        assertEquals(typedFields.get(0).getName(), "x");
        assertEquals(typedFields.get(0).getAccessModifier(), AccessModifier.PACKAGE_PRIVATE);
        assertEquals(typedFields.get(0).getVariableType(), ObjectType.IntType);
        assertEquals(typedFields.get(0).getObjectType(), ObjectType.IntType);
        assertEquals(typedFields.get(1).getName(), "y");
        assertEquals(typedFields.get(1).getAccessModifier(), AccessModifier.PACKAGE_PRIVATE);
        assertEquals(typedFields.get(1).getVariableType(), ObjectType.IntType);
        assertEquals(typedFields.get(1).getObjectType(), ObjectType.IntType);
        assertEquals(typedPointClass.getMethods().size(), 0);
        return true;
    }
}
