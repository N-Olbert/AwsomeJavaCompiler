package astgenerator.parser.astgen;

import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.While;

public class WhileGenerator {

    static While generate(awsomeJavaParser.JWhileContext whileContext){
        return new While(ExpressionGenerator.generate(whileContext.expression()),
                BlockGenerator.generate(whileContext.block()));
    }
}
