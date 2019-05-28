package astgenerator.parser.astgen;

import astgenerator.generalelements.Class;
import astgenerator.generalelements.FieldDeclaration;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.parser.generated.awsomeJavaParser;
import common.ObjectType;

import java.util.ArrayList;
import java.util.List;

class ClassGenerator {

    static Class generate(awsomeJavaParser.JClassContext classContext){
        List<FieldDeclaration> fieldDecls = new ArrayList<>();
        List<MethodDeclaration> methodDecls = new ArrayList<>();

        awsomeJavaParser.ClassBodyContext bodyContext = classContext.classBody();

        if (bodyContext.fieldDeclaration() != null) {
            bodyContext.fieldDeclaration().forEach(fieldDecl -> fieldDecls.add(FieldGenerator.generate(fieldDecl)));
        }

        methodDecls.addAll(MethodGenerator.generateConstructors(bodyContext,classContext.Identifier().getText()));

        if (bodyContext.mainMethod() != null){
            methodDecls.add(MethodGenerator.generateMainMethod(bodyContext.mainMethod()));
        }

        bodyContext.methodDeclaration().forEach(methodDecl ->
                methodDecls.add(MethodGenerator.generateMethod(methodDecl)));

        return new Class(ObjectType.getType(classContext.Identifier().getText()),fieldDecls,methodDecls);
    }
}
