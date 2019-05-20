package astgenerator.parser.astgen;

import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.MethodParameter;
import astgenerator.parser.generated.awsomeJavaParser;
import common.ObjectType;

import java.util.ArrayList;
import java.util.List;

public class MethodGenerator{

    public static MethodDeclaration generateConstructor(awsomeJavaParser.ClassBodyContext bodyContext, String classname){

        if (bodyContext.constructor() != null) {
            awsomeJavaParser.ConstructorContext constructorContext = bodyContext.constructor();
            return new MethodDeclaration(ObjectType.VoidType,
                    constructorContext.Identifier().getText(), generate(constructorContext.nMethodParameters()
                    .methodParameter()), null);
        } else {
            return new MethodDeclaration(ObjectType.VoidType, classname, new ArrayList<>(), null);
        }
    }

    public static MethodDeclaration generateMethod(awsomeJavaParser.MethodDeclarationContext context){
        List<MethodParameter> parameters = generate(context.nMethodParameters().methodParameter());
        context.nMethodParameters().methodParameter().forEach(methodParameterContext -> {
            parameters.add(new MethodParameter(ObjectType.getType(methodParameterContext.objectType().Identifier()
                    .getText()), methodParameterContext.Identifier().getText()));
        });
        return new MethodDeclaration(ObjectType.getType(context.objectType().Identifier().getText()),
                context.Identifier().getText(), parameters,null);
    }

    private static List<MethodParameter> generate(List<awsomeJavaParser.MethodParameterContext> contexts){
        List<MethodParameter> parameters = new ArrayList<>();
        for (awsomeJavaParser.MethodParameterContext methodParameterContext : contexts){

            ObjectType type = ObjectType.getType(methodParameterContext.objectType().Identifier().getText());
            parameters.add(new MethodParameter(type, methodParameterContext.Identifier().getText()));
        }
        return parameters;
    }

}
