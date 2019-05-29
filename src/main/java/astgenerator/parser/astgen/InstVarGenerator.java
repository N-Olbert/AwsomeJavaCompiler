package astgenerator.parser.astgen;

import astgenerator.expressions.*;
import astgenerator.parser.generated.awsomeJavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class InstVarGenerator {

    static InstVar generate(awsomeJavaParser.InstVarContext instVarContext){

        Object generated = generateInstVar(instVarContext.Identifier(),null,0);

        if (generated instanceof LocalOrFieldVar){ //this
            return new InstVar(new This(),((LocalOrFieldVar) generated).getName());
        }
        return (InstVar) generated;
    }

    private static Expression generateInstVar(List<TerminalNode> identifiers, Expression previous, int position){

        if (previous == null){
            previous = new LocalOrFieldVar(identifiers.get(position).getText());
        } else {
            previous = new InstVar(previous,identifiers.get(position).getText());
        }

        if (position < identifiers.size()-1){
            return generateInstVar(identifiers,previous,position+1);
        }
        return previous;
    }

}
