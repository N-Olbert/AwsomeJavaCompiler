package TypedASTTests;

import astgenerator.generalelements.UntypedProgram;
import common.ObjectType;
import tastgenerator.generalelements.TypedProgram;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class TypedTestClass1
{
    static final String BOOLVAR_NAME = "x1";
    static final String INTVAR_NAME = "x2";
    static final String CHARVAR_NAME = "x3";
    static final String OWNTYPE_NAME = "Test";
    static final String OWNTYPEVAR_NAME = "x4";

    static UntypedProgram getBasicProgram()
    {
        var fieldParams = new ArrayList<String[]>();
        fieldParams.add(new String[] { ObjectType.BoolType.getName(), BOOLVAR_NAME });
        fieldParams.add(new String[] { ObjectType.IntType.getName(), INTVAR_NAME });
        fieldParams.add(new String[] { ObjectType.CharType.getName(), CHARVAR_NAME });
        fieldParams.add(new String[] { ObjectType.getType(OWNTYPE_NAME).getName(), OWNTYPEVAR_NAME });
        var fields = UntypedProgramGenerator.getFields(fieldParams);
        return UntypedProgramGenerator.getProgram(OWNTYPE_NAME, fields, new ArrayList<>());
    }

    static void assertBasicProgram(TypedProgram program)
    {
        assertNotNull(program);
        assertNotNull(program.getClasses());
        assertEquals(program.getClasses().size(), 1);
        var myclass = program.getClasses().get(0);
        assertNotNull(myclass);
        assertEquals(myclass.getClassType(), ObjectType.getType(OWNTYPE_NAME));
        assertNotNull(myclass.getFields());
        assertEquals(myclass.getFields().size(), 4);
        var field = myclass.getFields().stream().filter(x -> BOOLVAR_NAME.equals(x.getName())).findFirst().get();
        assertEquals(field.getObjectType(), ObjectType.BoolType);
        field = myclass.getFields().stream().filter(x -> INTVAR_NAME.equals(x.getName())).findFirst().get();
        assertEquals(field.getObjectType(), ObjectType.IntType);
        field = myclass.getFields().stream().filter(x -> CHARVAR_NAME.equals(x.getName())).findFirst().get();
        assertEquals(field.getObjectType(), ObjectType.CharType);
        field = myclass.getFields().stream().filter(x -> OWNTYPEVAR_NAME.equals(x.getName())).findFirst().get();
        assertEquals(field.getObjectType(), ObjectType.getType(OWNTYPE_NAME));
    }
}
