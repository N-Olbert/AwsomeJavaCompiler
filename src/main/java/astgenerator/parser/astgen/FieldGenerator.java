package astgenerator.parser.astgen;

import astgenerator.generalelements.FieldDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.parser.generated.awsomeJavaParser;
import common.ObjectType;

public class FieldGenerator {

    public FieldDeclaration generate(awsomeJavaParser.FieldDeclarationContext fieldDecl){
        ObjectType type = null;

        if (fieldDecl.objectType().Identifier() != null){
            type = ObjectType.getType(fieldDecl.objectType().Identifier().getText());
        } else {
            String objectType = fieldDecl.objectType().Identifier().getText();

            switch (objectType){
                case "int":
                    type = ObjectType.IntType;
                    break;
                case "char":
                    type = ObjectType.CharType;
                    break;
                case "boolean":
                    type = ObjectType.BoolType;
                    break;
            }
        }

        return new FieldDeclaration(type, fieldDecl.Identifier().getText());
    }

}
