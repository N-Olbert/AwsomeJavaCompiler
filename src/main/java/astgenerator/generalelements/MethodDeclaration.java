package astgenerator.generalelements;

import astgenerator.statements.Statement;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;

import java.util.List;

public class MethodDeclaration extends GeneralThing
{
    private AccessModifier accessModifier;
    private Modifier modifier;
    private ObjectType returnType;
    private String name;
    private List<MethodParameter> params;
    private Statement stmt;

    public MethodDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType returnType,
                             String name, List<MethodParameter> params, Statement stmt) {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
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
