package astgenerator.parser;

import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.parser.generated.awsomeJavaParser;
import common.ObjectType;
import tastgenerator.Method;

import java.util.ArrayList;
import java.util.List;

public class ParseTreeGenerator {


    public UntypedProgram generate(awsomeJavaParser.ProgrammContext programContext) {

        //@ToDo Access Modifiers

        List<Class> classes = new ArrayList<>();

        UntypedProgram program = new UntypedProgram();

        programContext.jClass().forEach(classContext ->
        {
            awsomeJavaParser.ClassBodyContext bodyContext = classContext.classBody();
            List<FieldDeclaration> fieldDecls = new ArrayList<>();
            List<MethodDeclaration> methodDecls = new ArrayList<>();

               bodyContext.fieldDeclaration().forEach(fieldDecl -> {

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

               awsomeJavaParser.ConstructorContext constructorContext = bodyContext.constructor();
               methodDecls.add(new MethodDeclaration(ObjectType.VoidType,
                       constructorContext.Identifier().getText(), methodParameters(constructorContext),null));

               FieldDeclaration declaration = new FieldDeclaration(type, fieldDecl.Identifier().getText());

               fieldDecls.add(declaration);
           });

           Class clazz = new Class(ObjectType.getType(classContext.Identifier().getText()),fieldDecls,methodDecls);
           classes.add(clazz);
        });

        program.setClasses(classes);
        return program;
    }

    private List<MethodParameter> methodParameters(awsomeJavaParser.ConstructorContext constructorContext) {
        List<MethodParameter> parameters = new ArrayList<>();

        ObjectType type = null;

        for (awsomeJavaParser.MethodParameterContext methodParameterContext :
                constructorContext.nMethodParameters().methodParameter()) {

            if (methodParameterContext.objectType().Identifier() != null) {
                type = ObjectType.getType(methodParameterContext.objectType().Identifier().getText());
            } else {
                String objectType = methodParameterContext.objectType().Identifier().getText();

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

                parameters.add(new MethodParameter(type, methodParameterContext.Identifier().getText()));
            }
        }
        return parameters;
    }
}
