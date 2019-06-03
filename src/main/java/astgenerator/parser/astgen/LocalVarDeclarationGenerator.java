package astgenerator.parser.astgen;

import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.LocalVarDeclaration;
import astgenerator.statements.Statement;
import common.ObjectType;

import java.util.ArrayList;
import java.util.List;

public class LocalVarDeclarationGenerator {

    public static List<Statement> generate(awsomeJavaParser.LocalVarDeclarationContext localVarDeclarationContext){

        List<Statement> statements = new ArrayList<>();

        ObjectType type = ObjectTypeGenerator.generate(localVarDeclarationContext.objectType());

        localVarDeclarationContext.Identifier().forEach(identifier ->{
            statements.add(new LocalVarDeclaration(type,identifier.getText()));

            if (localVarDeclarationContext.expression() != null) {
                statements.add(new AssignStatement(new LocalOrFieldVar(identifier.getText()),
                        ExpressionGenerator.generate(localVarDeclarationContext.expression())));
            }
        });

        return statements;
    }
}
