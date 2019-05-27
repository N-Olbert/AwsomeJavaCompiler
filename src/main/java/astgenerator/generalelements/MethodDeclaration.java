package astgenerator.generalelements;

import astgenerator.statements.Block;
import astgenerator.statements.Statement;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;
import tastgenerator.generalelements.TypedMethodDeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MethodDeclaration extends GeneralThing
{
    private AccessModifier accessModifier;
    private Modifier modifier;
    private ObjectType returnType;
    private String name;
    private List<MethodParameter> params;
    private Block stmt;

    public MethodDeclaration(AccessModifier accessModifier, Modifier modifier, ObjectType returnType,
                             String name, List<MethodParameter> params, Block stmt) {
        this.accessModifier = accessModifier;
        this.modifier = modifier;
        this.returnType = returnType;
        this.name = name;
        this.params = params == null ? new ArrayList<>() : params;
        this.stmt = stmt == null ? new Block(new Statement[0]) : stmt;
    }

    public MethodDeclaration(ObjectType returnType, String name,
                             List<MethodParameter> params, Block stmt) {
        this.accessModifier = AccessModifier.PACKAGE_PRIVATE;
        this.modifier = Modifier.NONE;
        this.returnType = returnType;
        this.name = name;
        this.params = params == null ? new ArrayList<>() : params;
        this.stmt = stmt == null ? new Block(new Statement[0]) : stmt;
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

    public AccessModifier getAccessModifier() { return accessModifier; }

    public Modifier getModifier() { return modifier; }

    @Override
    public TypedMethodDeclaration toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodDeclaration that = (MethodDeclaration) o;
        return accessModifier == that.accessModifier &&
                modifier == that.modifier &&
                Objects.equals(returnType, that.returnType) &&
                Objects.equals(name, that.name) &&
                Objects.equals(params, that.params) &&
                Objects.equals(stmt, that.stmt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessModifier, modifier, returnType, name, params, stmt);
    }
}
