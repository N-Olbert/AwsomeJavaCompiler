package astgenerator.parser.astgen;

import astgenerator.expressions.*;
import astgenerator.parser.generated.awsomeJavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class InstVarGenerator {

    static InstVar generate(awsomeJavaParser.InstVarContext instVarContext){

        Object generated = generateInstVar(instVarContext.Identifier());

        if (generated instanceof LocalOrFieldVar){
            if (instVarContext.This() != null){
                return new InstVar(new This(),((LocalOrFieldVar) generated).getName());
            }
        }
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
