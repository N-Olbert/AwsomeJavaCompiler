package TypedASTTests;

import General.BytecodeLoader;
import General.ResourceHelper;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.Block;
import astgenerator.statements.Statement;
import common.Global;
import common.ObjectType;
import org.junit.Test;
import tastgenerator.TypeCheckerInstance;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TypedMethodTests
{
    @Test
    public void testConstructor1()
    {
        var ctor = new MethodDeclaration(ObjectType.VoidType, "Test", new ArrayList<>(), new Block(new Statement[0]));
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var typed = ctor.toTyped(converter);
        assertEquals(typed.getObjectType(), ObjectType.VoidType);
    }

    @Test
    public void testConstructor2()
    {
        var ctor = new MethodDeclaration(ObjectType.VoidType, "Test", new ArrayList<>(), new Block((ArrayList<Statement>) null));
        var converter = new TypeCheckerInstance(new UntypedProgram());
        var typed = ctor.toTyped(converter);
        assertEquals(typed.getObjectType(), ObjectType.VoidType);
    }
}
