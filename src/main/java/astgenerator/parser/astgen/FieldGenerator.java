package astgenerator.parser.astgen;

import astgenerator.generalelements.FieldDeclaration;
import astgenerator.parser.generated.awsomeJavaParser;
import common.Modifier;
import common.ObjectType;

class FieldGenerator {

    static FieldDeclaration generate(awsomeJavaParser.FieldDeclarationContext fieldDecl){
        ObjectType type = null;

        if (fieldDecl.objectType().Identifier() != null){
            type = ObjectType.getType(fieldDecl.objectType().Identifier().getText());
        } else {
            String objectType = fieldDecl.objectType().getText();

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

        return new FieldDeclaration(AccessModifierGenerator.generate(fieldDecl.AccessModifier()),
                Modifier.NONE, type,  fieldDecl.Identifier().getText());
    }

}
