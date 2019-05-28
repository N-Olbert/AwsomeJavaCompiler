package astgenerator.parser.astgen;

import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.Return;

public class ReturnGenerator {

    static Return generate(awsomeJavaParser.JReturnContext returnContext){
        return new Return(ExpressionGenerator.generate(returnContext.expression()));
    }
}
