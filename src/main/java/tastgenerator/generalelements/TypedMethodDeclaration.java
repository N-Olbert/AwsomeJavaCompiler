package tastgenerator.generalelements;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import tastgenerator.statements.TypedBlock;

import java.util.List;

public class TypedMethodDeclaration extends TypedGeneralThing
{
    private AccessModifier accessModifier;
    private Modifier modifier;
    private ObjectType returnType;
    private String name;
    private List<TypedMethodParameter> params;
    private TypedBlock stmt;

    public TypedMethodDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType returnType,
                                  String name, List<TypedMethodParameter> params, TypedBlock stmt) {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.stmt = stmt;
    }

    public TypedMethodDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType returnType,
                                  String name, List<TypedMethodParameter> params, TypedBlock stmt, ObjectType objectType) {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.stmt = stmt;
        setObjectType(objectType);
    }

    public ObjectType getReturnType()
    {
        return returnType;
    }

    public String getName()
    {
        return name;
    }

    public List<TypedMethodParameter> getParams()
    {
        return params;
    }

    public TypedBlock getStmt()
    {
        return stmt;
    }

    public AccessModifier getAccessModifier() { return accessModifier; }

    public Modifier getModifier() { return modifier; }
}
