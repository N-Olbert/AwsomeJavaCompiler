package TypedASTTests;

import astgenerator.expressions.JBoolean;
import astgenerator.expressions.JCharacter;
import astgenerator.expressions.JInteger;
import astgenerator.generalelements.Class;
import astgenerator.generalelements.FieldDeclaration;
import astgenerator.generalelements.UntypedProgram;
import common.*;

import static org.junit.Assert.*;
import org.junit.Test;
import tastgenerator.TypeCheckerInstance;
import tastgenerator.generalelements.TypedClass;
import tastgenerator.generalelements.TypedProgram;

import java.util.ArrayList;
import java.util.List;

public class TypedASTBaseTests
{
    @Test
    public void testASTGeneration()
    {
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        TypedASTGenerator astGen = factory.getTypedAstGenerator();
        assertNotNull(astGen);

        String className = "Point";
        UntypedProgram testProgram = new UntypedProgram();
        List<Class> classes = new ArrayList<Class>();
        List<FieldDeclaration> fields = new ArrayList<FieldDeclaration>();
        FieldDeclaration field1 = new FieldDeclaration(ObjectType.IntType, "x");
        FieldDeclaration field2 = new FieldDeclaration(ObjectType.IntType, "y");
        fields.add(field1);
        fields.add(field2);
        Class pointClass = new Class(ObjectType.getType(className), fields, new ArrayList<>());
        classes.add(pointClass);
        testProgram.setClasses(classes);

        TypedProgram ast = astGen.getTypedProgram(testProgram);
        assertNotNull(ast);
        assertEquals(ast.getClasses().size(), 1);
        var typedPointClass = ast.getClasses().get(1);
        assertEquals(ast.getObjectType(), ObjectType.getType(className));
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
    }

    @Test
    public void testConvertBoolExpression()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var bool = new JBoolean("false");
        var typed = bool.toTyped(converter);
        assertNotNull(typed);
        assertEquals(typed.getObjectType(), ObjectType.BoolType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCharacterThrowsOnInvalidInput()
    {
        new JCharacter("test");
    }

    @Test
    public void testConvertCharExpression()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var bool = new JCharacter("g");
        var typed = bool.toTyped(converter);
        assertNotNull(typed);
        assertEquals(typed.getObjectType(), ObjectType.CharType);
    }

    @Test
    public void testConvertIntExpression()
    {
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var bool = new JInteger("5");
        var typed = bool.toTyped(converter);
        assertNotNull(typed);
        assertEquals(typed.getObjectType(), ObjectType.IntType);
    }

    public void testTypedInstVar()
    {
       /* var converter = new TypeCheckerInstance();
        var bool = new JInteger("5");
        var typed = bool.toTyped(converter);
        assertNotNull(typed);
        assertEquals(typed.getObjectType(), ObjectType.IntType);*/
    }

    private UntypedProgram getUntypedProgramWithBasicTypes()
    {
        var fieldsList = new ArrayList<String[]>();
        fieldsList.add(new String[]{int.class.toString(), "i"});
        return new UntypedProgram();
    }
}
