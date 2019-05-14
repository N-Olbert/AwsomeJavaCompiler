import ASTTests.ASTBaseTest;
import BytecodeTests.BytecodeTests;
import General.GeneralTests;
import IntegrationTests.IntegrationTests;
import TypedASTTests.TypedASTBaseTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


// Comment in the TestClasses you want to have!
@Suite.SuiteClasses({
        //ASTBaseTest.class,
        //BytecodeTests.class,
        //GeneralTests.class,
        //TypedASTBaseTests.class
        IntegrationTests.class
})
@RunWith(Suite.class)
public class TestSuite
{
}
