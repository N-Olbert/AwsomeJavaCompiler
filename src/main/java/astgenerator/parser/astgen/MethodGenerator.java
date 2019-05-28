package astgenerator.parser.astgen;

import astgenerator.generalelements.MainMethodDeclaration;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.Block;
import common.Modifier;
import common.ObjectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MethodGenerator{

    static MethodDeclaration generateConstructor(awsomeJavaParser.ClassBodyContext bodyContext, String classname){

        if (bodyContext.constructor() != null) {
            awsomeJavaParser.ConstructorContext constructorContext = bodyContext.constructor();
            return new MethodDeclaration(AccessModifierGenerator.generate(constructorContext.AccessModifier()),
                    Modifier.NONE,
                    ObjectType.VoidType,
                    constructorContext.Identifier().getText(), generate(constructorContext.nMethodParameters()
                    .methodParameter()), null);
        } else {
            return new MethodDeclaration(ObjectType.VoidType, classname, new ArrayList<>(), new Block());
        }
    }

    static MainMethodDeclaration generateMainMethod(awsomeJavaParser.MainMethodContext context){
        return new MainMethodDeclaration(BlockGenerator.generate(context.block()));
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
