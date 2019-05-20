package astgenerator.parser.astgen;

import astgenerator.generalelements.Class;
import astgenerator.generalelements.FieldDeclaration;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.parser.generated.awsomeJavaParser;
import common.ObjectType;

import java.util.ArrayList;
import java.util.List;

public class ClassGenerator {

    public static Class generate(awsomeJavaParser.JClassContext classContext){
        List<FieldDeclaration> fieldDecls = new ArrayList<>();
        List<MethodDeclaration> methodDecls = new ArrayList<>();

        awsomeJavaParser.ClassBodyContext bodyContext = classContext.classBody();

        FieldGenerator fieldGenerator = new FieldGenerator();
        bodyContext.fieldDeclaration().forEach(fieldDecl -> fieldDecls.add(fieldGenerator.generate(fieldDecl)));

        methodDecls.add(MethodGenerator.generateConstructor(bodyContext,classContext.Identifier().getText()));

        bodyContext.methodDeclaration().forEach(methodDecl -> {
            methodDecls.add(MethodGenerator.generateMethod(methodDecl));
        });

        return new Class(ObjectType.getType(classContext.Identifier().getText()),fieldDecls,methodDecls);
    }
}
