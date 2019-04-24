package tastgenerator.generalelements;

import tastgenerator.statements.Statement;

import java.util.List;

public class MethodDeclaration
{
    private ObjectType type;
    private ObjectType returnType;
    private String name;
    private List<MethodParameter> params;
    private Statement stmt;

    public MethodDeclaration(ObjectType returnType, String name, List<MethodParameter> params, Statement stmt) {
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

    public List<MethodParameter> getParams()
    {
        return params;
    }

    public Statement getStmt()
    {
        return stmt;
    }
}
