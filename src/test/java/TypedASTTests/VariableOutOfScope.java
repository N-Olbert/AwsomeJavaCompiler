package TypedASTTests;

import astgenerator.expressions.Binary;
import astgenerator.expressions.JBoolean;
import astgenerator.expressions.JInteger;
import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.generalelements.MethodDeclaration;
import astgenerator.generalelements.UntypedProgram;
import astgenerator.statements.AssignStatement;
import astgenerator.statements.Block;
import astgenerator.statements.IfElse;
import astgenerator.statements.LocalVarDeclaration;
import common.*;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class VariableOutOfScope
{
    @Test(expected = Exception.class)
    public void OutOfScopeTest()
    {
        var method = new Block(new IfElse(
                new Binary(new JBoolean("true"), new JBoolean("true"), Operators.EQUALS),
                new Block(new LocalVarDeclaration(ObjectType.IntType, "a"), new AssignStatement(new LocalOrFieldVar("a"), new JInteger("5"))),
                new Block(new AssignStatement(new LocalOrFieldVar("a"), new JInteger("4")))
        ));
        var methodDecl = new MethodDeclaration(AccessModifier.PUBLIC, Modifier.NONE, ObjectType.VoidType, "blub", new ArrayList<>(),method);
        var program = UntypedProgramGenerator.getProgram("Klasse", new ArrayList <>(), Collections.singletonList(methodDecl));

        Global.getFactory().getTypedAstGenerator().getTypedProgram(program);
    }
}
