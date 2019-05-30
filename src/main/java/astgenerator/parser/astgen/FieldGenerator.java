package astgenerator.parser.astgen;

import astgenerator.generalelements.FieldDeclaration;
import astgenerator.parser.generated.awsomeJavaParser;
import common.Modifier;
import common.ObjectType;

import java.util.ArrayList;
import java.util.List;

class FieldGenerator {

    static List<FieldDeclaration> generate(awsomeJavaParser.FieldDeclarationContext fieldDecl){

        List<FieldDeclaration> declarations = new ArrayList<>();

        fieldDecl.Identifier().forEach(identifier -> {

            ObjectType type = null;

            if (fieldDecl.objectType().Identifier() != null) {
                type = ObjectType.getType(fieldDecl.objectType().Identifier().getText());
            } else {
                String objectType = fieldDecl.objectType().getText();

                switch (objectType) {
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

            if (fieldDecl.expression() != null){
                declarations.add(new FieldDeclaration(AccessModifierGenerator.generate(fieldDecl.AccessModifier()),
                        Modifier.NONE, type, identifier.getText(),
                        ExpressionGenerator.generate(fieldDecl.expression())));
            } else {
                declarations.add(new FieldDeclaration(AccessModifierGenerator.generate(fieldDecl.AccessModifier()),
                        Modifier.NONE, type, identifier.getText()));
            }
        });

        return declarations;
    }

}
