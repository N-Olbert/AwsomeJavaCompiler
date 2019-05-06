package tastgenerator.generalelements;

import common.ObjectType;
import tastgenerator.statements.TypedWhile;

import java.util.List;

public class TypedClass extends TypedGeneralThing
{
    private ObjectType classType;
    private List<TypedFieldDeclaration> fields;
    private List<TypedMethodDeclaration> methods;

    public TypedClass(ObjectType classType, List<TypedFieldDeclaration> fields, List<TypedMethodDeclaration> methods)
    {
        this.classType = classType;
        this.fields = fields;
        this.methods = methods;
    }

    public ObjectType getClassType()
    {
        return classType;
    }

    public List<TypedFieldDeclaration> getFields()
    {
        return fields;
    }

    public List<TypedMethodDeclaration> getMethods()
    {
        return methods;
    }
}
