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
import tastgenerator.generalelements.TypedProgram;

import java.util.ArrayList;
import java.util.List;

public class TypedASTBaseTests
{
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
