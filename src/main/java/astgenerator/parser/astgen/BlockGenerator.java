package astgenerator.parser.astgen;

import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.Block;
import astgenerator.statements.Statement;

import java.util.ArrayList;
import java.util.List;

class BlockGenerator {

    static Block generate(awsomeJavaParser.BlockContext blockContext){

        List<Statement> statements = new ArrayList<>();

        if (blockContext.statement() != null) {
            if (blockContext.statement().size() > 0) {
                blockContext.statement().forEach(statement ->
                        statements.addAll(StatementGenerator.generate(statement)));
            }
        }

        return new Block(statements.toArray(new Statement[]{}));
    }
}
