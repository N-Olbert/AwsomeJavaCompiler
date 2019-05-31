package astgenerator.parser.astgen;

import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.Block;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;

import java.util.ArrayList;
import java.util.List;

class MethodGenerator{

    static List<MethodDeclaration> generateConstructors(awsomeJavaParser.ClassBodyContext bodyContext,
                                                        String classname) {

        List<MethodDeclaration> constructorDecls = new ArrayList<>();

        bodyContext.constructor().forEach(constructorContext -> {
            Block block = null;

            if (constructorContext.block() != null) {
                block = BlockGenerator.generate(constructorContext.block());
            }

            constructorDecls.add(new MethodDeclaration(
                    AccessModifierGenerator.generate(constructorContext.AccessModifier()),
                    Modifier.NONE,
                    ObjectType.VoidType,
                    constructorContext.Identifier().getText(),
                    generate(constructorContext.nMethodParameters().methodParameter()),
                    block));
        });

        if (constructorDecls.size() == 0){
            
            constructorDecls.add(new MethodDeclaration(AccessModifier.PACKAGE_PRIVATE,
                    Modifier.NONE,
                    ObjectType.VoidType,
                    classname,
                    new ArrayList<>(),
                    new Block(new ArrayList<>())));
        }

        return constructorDecls;
    }

    static MethodDeclaration generateMainMethod(awsomeJavaParser.MainMethodContext context){
        return new MethodDeclaration(
                AccessModifier.PUBLIC,
                Modifier.STATIC,
                ObjectType.VoidType,
                "main",
                new ArrayList<>(),
                BlockGenerator.generate(context.block()));
    }

    static MethodDeclaration generateMethod(awsomeJavaParser.MethodDeclarationContext context){

        List<MethodParameter> parameters = new ArrayList<>();

        if (context.nMethodParameters() != null) {
            if (context.nMethodParameters().methodParameter() != null) {
                 parameters = generate(context.nMethodParameters().methodParameter());
            }
        }

        if (context.objectType() != null) {
            return new MethodDeclaration(AccessModifierGenerator.generate(context.AccessModifier()), Modifier.NONE,
                    ObjectTypeGenerator.generate(context.objectType()),
                    context.Identifier().getText(), parameters, BlockGenerator.generate(context.block()));
        } else {
            return new MethodDeclaration(AccessModifierGenerator.generate(context.AccessModifier()), Modifier.NONE,
                    ObjectType.VoidType,
                    context.Identifier().getText(), parameters, BlockGenerator.generate(context.block()));
        }
    }

    private static List<MethodParameter> generate(List<awsomeJavaParser.MethodParameterContext> contexts){
        List<MethodParameter> parameters = new ArrayList<>();
            for (awsomeJavaParser.MethodParameterContext methodParameterContext : contexts) {

                ObjectType type = ObjectTypeGenerator.generate(methodParameterContext.objectType());
                parameters.add(new MethodParameter(type, methodParameterContext.Identifier().getText()));
            }
        return parameters;
    }

}
