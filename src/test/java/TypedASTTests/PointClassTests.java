package TypedASTTests;

import astgenerator.expressions.InstVar;
import astgenerator.expressions.This;
import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.statements.Block;
import astgenerator.statements.Return;
import common.*;
import org.junit.Test;
import tastgenerator.expressions.TypedInstVar;
import tastgenerator.expressions.TypedThis;
import tastgenerator.generalelements.TypedMethodDeclaration;
import tastgenerator.generalelements.TypedProgram;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedReturn;

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
        assertEquals(typed.getClasses().get(0).getMethods().size(), 0);
    }

    @Test
    public void testPointClassGetters()
    {
        Factory factory = Global.getFactory();
        assertNotNull(factory);
        TypedASTGenerator astGen = factory.getTypedAstGenerator();
        assertNotNull(astGen);
        var baseClass = getBasePointClass();
        baseClass = getPointClassWithGetters(baseClass);
        var typed = astGen.getTypedProgram(baseClass);
        assertTrue(assertDefaultPointClass(typed));
        assertTrue(assertPointClassWithGetters(typed));
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

    private UntypedProgram getPointClassWithGetters(UntypedProgram baseClass)
    {
        var methods = baseClass.getClasses().get(1).getMethods();
        var returnStatement1 = new Block(new Return(new InstVar(new This(), "x")));
        var returnStatement2 = new Block(new Return(new InstVar(new This(), "y")));

        /**
         * public int getX()
         * {
         *      return this.x;
         * }
         *
         * public int getY()
         * {
         *     return this.y;
         * }
         */
        var getX = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                                         ObjectType.IntType, "getX",
                                         new ArrayList<>(), returnStatement1);
        methods.add(getX);
        var getY = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE,
                                         ObjectType.IntType, "getY",
                                         new ArrayList<>(), returnStatement2);
        methods.add(getY);
        return baseClass;
    }

    private UntypedProgram getPointClassWithGetSumMethod(UntypedProgram baseClass)
    {
        var methods = baseClass.getClasses().get(1).getMethods();
        /**
         * public int getXY()
         * {
         *      int i;
         *      i = this.X + this.Y;
         *      return i;
         *  }
         */

        return baseClass;
    }

    private boolean assertDefaultPointClass(TypedProgram typedProgram)
    {
        assertNotNull(typedProgram);
        assertEquals(typedProgram.getClasses().size(), 1);
        var typedPointClass = typedProgram.getClasses().get(0);
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
        return true;
    }

    private boolean assertPointClassWithGetters(TypedProgram typedProgram)
    {
        assertEquals(typedProgram.getClasses().size(), 1);
        var typedPointClass = typedProgram.getClasses().get(0);
        assertEquals(typedProgram.getObjectType(), ObjectType.getType("Point"));
        var getX = typedPointClass.getMethods().stream().filter(x -> x.getName().equals("getX")).findFirst().get();
        var getY = typedPointClass.getMethods().stream().filter(x -> x.getName().equals("getY")).findFirst().get();
        for(TypedMethodDeclaration tm : new TypedMethodDeclaration[] {getX, getY})
        {
            assertNotNull(tm);
            assertEquals(tm.getObjectType(), ObjectType.IntType);
            var block = tm.getStmt();
            assertNotNull(block);
            assertEquals(block.getObjectType(), ObjectType.IntType);
            assertNotNull(block.getBlockedStatements());
            assertEquals(block.getBlockedStatements().size(), 1);
            assertTrue(block.getBlockedStatements().get(0) instanceof TypedReturn);
            var r = (TypedReturn)block.getBlockedStatements().get(0);
            assertEquals(r.getObjectType(), ObjectType.IntType);
            assertTrue(r.getExp() instanceof TypedInstVar);
            var t = (TypedInstVar)r.getExp();
            assertEquals(t.getObjectType(), ObjectType.IntType);
            assertTrue(t.getExpression() instanceof TypedThis);
            assertEquals(t.getExpression().getObjectType(), ObjectType.getType("Point"));
        }

        return true;
    }
}
