package BytecodeTests;

import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import tastgenerator.generalelements.*;
import tastgenerator.statements.TypedBlock;

import java.util.ArrayList;
import java.util.List;

public class TypedProgramGenerator
{
    public static TypedProgram getProgram(String className, List <TypedFieldDeclaration> fields, List <TypedMethodDeclaration> methods)
    {
        var classes = new ArrayList <TypedClass>();
        var newClass = new TypedClass(ObjectType.getType(className), fields, methods);
        newClass.setObjectType(ObjectType.getType(className));
        classes.add(newClass);
        var testProgram = new TypedProgram(classes);
        return testProgram;
    }

    public static List<TypedFieldDeclaration> getFields(List<String[]> params)
    {
        var fieldList = new ArrayList<TypedFieldDeclaration>();
        for(String[] s : params)
        {
            TypedFieldDeclaration f;
            if(s.length == 2)
            {
                f = new TypedFieldDeclaration(AccessModifier.PACKAGE_PRIVATE,Modifier.NONE, ObjectType.getType(s[0]), s[1]);
                f.setObjectType(ObjectType.getType(s[0]));
            }
            else if (s.length == 4)
            {
                var amodifier = AccessModifier.valueOf(s[0]);
                var modifier = Modifier.valueOf(s[1]);
                f = new TypedFieldDeclaration(amodifier, modifier, ObjectType.getType(s[0]), s[1]);
                f.setObjectType(ObjectType.getType(s[0]));
            }
            else
            {
                throw new IllegalArgumentException();
            }

            fieldList.add(f);
        }

        return fieldList;
    }

    public static List<TypedMethodDeclaration> getMethodsWithoutParams(List<String[]> params, List<TypedBlock> stmts)
    {
        var methodList = new ArrayList<TypedMethodDeclaration>();
        for(String[] s : params)
        {
            TypedMethodDeclaration m;
            if(s.length == 2)
            {
                m = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE,Modifier.NONE,ObjectType.getType(s[0]), s[1], new ArrayList<>(), stmts.get(params.indexOf(s)));
                m.setObjectType(ObjectType.getType(s[0]));
            }
            else if(s.length == 4)
            {
                var amodifier = AccessModifier.valueOf(s[0]);
                var modifier = Modifier.valueOf(s[1]);
                m = new TypedMethodDeclaration(amodifier, modifier, ObjectType.getType(s[2]), s[3], new ArrayList<>(), stmts.get(params.indexOf(s)));
                m.setObjectType(ObjectType.getType(s[0]));
            }
            else
            {
                throw new IllegalArgumentException();
            }

            methodList.add(m);
        }

        return methodList;
    }

    public static List<TypedMethodDeclaration> getMethods(List <String[]> params, List <TypedBlock> stmts, List <ArrayList <TypedMethodParameter>> parameters)
    {
        var methodList = new ArrayList<TypedMethodDeclaration>();
        for(String[] s : params)
        {
            TypedMethodDeclaration m;
            if(s.length == 2)
            {
                m = new TypedMethodDeclaration(AccessModifier.PACKAGE_PRIVATE,Modifier.NONE,ObjectType.getType(s[0]), s[1], parameters.get(params.indexOf(s)), stmts.get(params.indexOf(s)));
                m.setObjectType(ObjectType.getType(s[0]));
            }
            else if(s.length == 4)
            {
                var amodifier = AccessModifier.valueOf(s[0]);
                var modifier = Modifier.valueOf(s[1]);
                m = new TypedMethodDeclaration(amodifier, modifier, ObjectType.getType(s[2]), s[3], parameters.get(params.indexOf(s)), stmts.get(params.indexOf(s)));
                m.setObjectType(ObjectType.getType(s[0]));
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
