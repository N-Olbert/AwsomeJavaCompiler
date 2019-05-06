package tastgenerator.generalelements;
import common.ObjectType;
import tastgenerator.statements.TypedBlock;

import java.util.List;

public class TypedMethodDeclaration extends TypedGeneralThing
{
    private ObjectType returnType;
    private String name;
    private List<TypedMethodParameter> params;
    private TypedBlock stmt;

    public TypedMethodDeclaration(ObjectType returnType, String name, List<TypedMethodParameter> params, TypedBlock stmt) {
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.stmt = stmt;
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
}
