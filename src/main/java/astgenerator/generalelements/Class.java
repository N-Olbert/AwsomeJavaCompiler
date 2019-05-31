package astgenerator.generalelements;

import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(classType, aClass.classType) &&
                Objects.equals(fields, aClass.fields) &&
                Objects.equals(methods, aClass.methods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classType, fields, methods);
    }
}
