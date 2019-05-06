package TypedASTTests;

import astgenerator.generalelements.Class;
import astgenerator.generalelements.FieldDeclaration;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.Statement;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import tastgenerator.generalelements.TypedProgram;

import java.util.ArrayList;
import java.util.List;

public class UntypedProgramGenerator
{
    public static UntypedProgram getProgram(String className, List<FieldDeclaration> fields, List<MethodDeclaration> methods)
    {
        var testProgram = new UntypedProgram();
        var classes = new ArrayList<Class>();
        var newClass = new Class(ObjectType.getType(className), fields, methods);
        classes.add(newClass);
        testProgram.setClasses(classes);
        return testProgram;
    }

    public static List<FieldDeclaration> getFields(List<String[]> params)
    {
        var fieldList = new ArrayList<FieldDeclaration>();
        for(String[] s : params)
        {
            FieldDeclaration f;
            if(s.length == 2)
            {
                f = new FieldDeclaration(ObjectType.getType(s[0]), s[1]);
            }
            else if (s.length == 4)
            {
                var amodifier = AccessModifier.valueOf(s[0]);
                var modifier = Modifier.valueOf(s[1]);
                f = new FieldDeclaration(amodifier, modifier, ObjectType.getType(s[0]), s[1]);
            }
            else
            {
                throw new IllegalArgumentException();
            }

            fieldList.add(f);
        }

        return fieldList;
    }

    public static List<MethodDeclaration> getMethodsWithoutParams(List<String[]> params, List<Statement> stmts)
    {
        var methodList = new ArrayList<MethodDeclaration>();
        for(String[] s : params)
        {
            MethodDeclaration m;
            if(s.length == 4)
            {
               m = new MethodDeclaration(ObjectType.getType(s[0]), s[1], new ArrayList<>(), stmts.get(params.indexOf(s)));
            }
            else if(s.length == 6)
            {
                var amodifier = AccessModifier.valueOf(s[0]);
                var modifier = Modifier.valueOf(s[1]);
                m = new MethodDeclaration(amodifier, modifier, ObjectType.getType(s[2]), s[3], new ArrayList<>(), stmts.get(params.indexOf(s)));
            }
            else
            {
                throw new IllegalArgumentException();
            }

            methodList.add(m);
        }

        return methodList;
    }
}
