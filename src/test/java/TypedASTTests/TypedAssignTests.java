package TypedASTTests;

import astgenerator.expressions.AssignExpression;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.IfElse;
import org.junit.Test;
import tastgenerator.TypeCheckerInstance;
import tastgenerator.expressions.TypedExpression;

public class TypedAssignTests
{
    @Test
    public void testTypedAssignExpression()
    {
        var program = TypedTestClass1.getBasicProgram();
        var converter = new TypeCheckerInstance(program);

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
    }
}
