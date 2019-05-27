package astgenerator.parser.astgen;

import common.AccessModifier;
import org.antlr.v4.runtime.tree.TerminalNode;

class AccessModifierGenerator {

    static AccessModifier generate(TerminalNode accessModifier){

        if (accessModifier == null){
            return AccessModifier.PACKAGE_PRIVATE;
        }

        switch (accessModifier.getText()){
            case "public":
                return AccessModifier.PUBLIC;
            case "private":
                return AccessModifier.PRIVATE;
            default:
                return AccessModifier.PROTECTED;
        }
    }

}
