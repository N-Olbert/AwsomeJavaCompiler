package TypedASTTests;

import astgenerator.expressions.*;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.statements.*;
import common.ObjectType;
import common.Operators;
import org.junit.Test;
import static org.junit.Assert.*;
import tastgenerator.TypeCheckerInstance;
import tastgenerator.expressions.*;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedIfElse;
import tastgenerator.statements.TypedLocalVarDeclaration;

import java.util.ArrayList;

public class TypedAssignTests
{
    @Test
    public void testTypedAssignExpression()
    {
        /**
        public boolean testAssignExpression()
        {
            boolean b;
            if((b = 1 == 1) == true)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
         **/

        var program = TypedTestClass1.getBasicProgram();
        var block = new Block(
                        new LocalVarDeclaration(ObjectType.BoolType, "b"),
                        new IfElse(
                                new Binary(
                                        new AssignExpression(new LocalOrFieldVar("b"),
                                                             new Binary(new JInteger("1"),
                                                             new JInteger("1"), Operators.EQUALS)),
                                        new JBoolean("true"), Operators.EQUALS),
                                new Block(new Return(new JBoolean("true"))),
                                new Block(new Return(new JBoolean("false")))));

        var methodDecl = new MethodDeclaration(ObjectType.BoolType,
                                        "testAssignExpression", new ArrayList<>(), block);
        program.getClasses().get(0).getMethods().add(methodDecl);
        var converter = new TypeCheckerInstance(program);
        var typed = block.toTyped(converter);
        assertNotNull(typed);
        assertEquals(typed.getObjectType(), ObjectType.BoolType);
        var localVar = (TypedLocalVarDeclaration)((TypedBlock)typed).getBlockedStatements().get(0);
        assertNotNull(localVar);
        assertEquals(localVar.getObjectType(), ObjectType.VoidType);

        var ifElse = (TypedIfElse)((TypedBlock)typed).getBlockedStatements().get(1);
        assertEquals(ifElse.getObjectType(), ObjectType.BoolType);
        assertEquals(ifElse.getThen().getObjectType(), ObjectType.BoolType);
        assertEquals(ifElse.getOtherwise().getObjectType(), ObjectType.BoolType);

        var binary = (TypedBinary)ifElse.getCondition();
        assertEquals(binary.getOperator(), Operators.EQUALS);
        assertEquals(binary.getObjectType(), ObjectType.BoolType);

        var assign = (TypedAssignExpression)binary.getExpression();
        assertEquals(assign.getObjectType(), ObjectType.BoolType); //this is the vital one
        var assignTarget = (TypedLocalOrFieldVar)assign.getExpression1();
        assertEquals(assignTarget.getName(), "b");
        assertEquals(assignTarget.getObjectType(), ObjectType.BoolType);
        var assignValue = (TypedBinary)assign.getExpression2();
        assertEquals(assignValue.getOperator(), Operators.EQUALS);
        assertTrue(assignValue.getExpression() instanceof TypedInt);
        assertEquals(assignValue.getExpression().getObjectType(), ObjectType.IntType);
        assertTrue(assignValue.getExpression2() instanceof TypedInt);
        assertEquals(assignValue.getExpression2().getObjectType(), ObjectType.IntType);

        var toCompare = binary.getExpression2();
        assertEquals(assignValue.getObjectType(), ObjectType.BoolType);
        assertTrue(toCompare instanceof TypedBoolean);
    }
}
