package astgenerator.generalelements;

import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

import java.util.ArrayList;
import java.util.List;

public class Class extends GeneralThing
{
    private ObjectType classType;
    private List<FieldDeclaration> fields;
    private List<MethodDeclaration> methods;

    public Class(ObjectType classType, List<FieldDeclaration> fields, List<MethodDeclaration> methods)
    {
        this.classType = classType;
        this.fields = fields == null ? new ArrayList<>() : fields;
        this.methods = methods == null ? new ArrayList<>() : methods;
    }

    public ObjectType getClassType()
    {
        return classType;
    }

    public List<FieldDeclaration> getFields()
    {
        return fields;
    }

    public List<MethodDeclaration> getMethods()
    {
        return methods;
    }

    @Override
    public TypedGeneralThing toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
