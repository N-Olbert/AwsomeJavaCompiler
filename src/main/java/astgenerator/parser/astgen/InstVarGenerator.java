package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.expressions.InstVar;
import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.parser.generated.awsomeJavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class InstVarGenerator {

    static InstVar generate(awsomeJavaParser.InstVarContext instVarContext){
        return (InstVar) generateInstVar(instVarContext.Identifier());
    }

    private static Expression generateInstVar(List<TerminalNode> identifiers){
        if (identifiers.size() > 1){
            return new InstVar(generateInstVar(identifiers.subList(1,identifiers.size())),identifiers.get(0).getText());
        } else {
            return new LocalOrFieldVar(identifiers.get(0).getText());
        }
    }

}
