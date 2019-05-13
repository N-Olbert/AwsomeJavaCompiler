package astgenerator.generalelements;

import astgenerator.statements.Block;
import astgenerator.statements.Statement;
import common.AccessModifier;
import common.Modifier;
import common.ObjectType;
import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

import java.util.List;

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
        this.params = params;
        this.stmt = stmt;
    }

    public MethodDeclaration(ObjectType returnType, String name,
                             List<MethodParameter> params, Block stmt) {
        this.accessModifier = AccessModifier.PACKAGE_PRIVATE;
        this.modifier = Modifier.NONE;
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

    public Block getStmt()
    {
        return stmt;
    }

    public AccessModifier getAccessModifier() { return accessModifier; }

    public Modifier getModifier() { return modifier; }

    @Override
    public TypedGeneralThing toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }
}
