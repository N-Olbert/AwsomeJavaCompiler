package astgenerator.parser.astgen;

import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.LocalVarDeclaration;
import common.ObjectType;

public class LocalVarDeclarationGenerator {

    public static LocalVarDeclaration generate(awsomeJavaParser.LocalVarDeclarationContext localVarDeclarationContext){
        ObjectType type = ObjectTypeGenerator.generate(localVarDeclarationContext.objectType());

        return new LocalVarDeclaration(type,localVarDeclarationContext.Identifier().getText());
    }
}
