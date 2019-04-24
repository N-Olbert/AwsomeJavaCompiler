package tastgenerator.generalelements;

import java.util.List;

public class Class
{
    private ObjectType classType;
    private List<FieldDeclaration> fields;
    private List<MethodDeclaration> methods;

    public Class(ObjectType classType, List<FieldDeclaration> fields, List<MethodDeclaration> methods)
    {
        this.classType = classType;
        this.fields = fields;
        this.methods = methods;
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
}
