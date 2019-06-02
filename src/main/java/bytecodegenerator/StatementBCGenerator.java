package bytecodegenerator;

import bytecodegenerator.exceptions.NotImplementedYetException;
import common.ObjectType;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.statements.TypedAssignStatement;
import tastgenerator.statements.TypedBlock;
import tastgenerator.statements.TypedIfElse;
import tastgenerator.statements.TypedLocalVarDeclaration;
import tastgenerator.statements.TypedMethodCallStatement;
import tastgenerator.statements.TypedNewStatement;
import tastgenerator.statements.TypedReturn;
import tastgenerator.statements.TypedStatement;
import tastgenerator.statements.TypedWhile;

import static bytecodegenerator.GeneratorUtils.*;
import static org.objectweb.asm.Opcodes.*;

/**
 * The ExpressionBCGenerator contains the generators of all {@link TypedStatement}
 *
 * @author Nico Dreher
 * @see bytecodegenerator.interfaces.ByteCodeGeneratable
 */
public class StatementBCGenerator {
    public static void generate(TypedBlock block, MethodVisitor visitor, Context context) {
        Context childContext = context.clone();
        if(block.getBlockedStatements() != null) {
            block.getBlockedStatements().forEach(statement -> statement.generateByteCode(visitor, childContext));
        }
    }

    public static void generate(TypedReturn statement, MethodVisitor visitor, Context context) {
        switch(statement.getObjectType().getName()) {
            case "C": //Fall Trough
            case "Z":
            case "I":
                statement.getExp().generateByteCode(visitor, context);
                visitor.visitInsn(IRETURN);
                break;
            case "V":
                visitor.visitInsn(RETURN);
                break;
            default:
                statement.getExp().generateByteCode(visitor, context);
                visitor.visitInsn(ARETURN);
        }
    }

    public static void generate(TypedAssignStatement statement, MethodVisitor visitor, Context context) {
        generateAssign(statement.getExpression1(), statement.getExpression2(), visitor, context);
    }

    public static void generate(TypedIfElse statement, MethodVisitor visitor, Context context) {
        Label l0 = new Label();
        Label finish = new Label();
        statement.getCondition().generateByteCode(visitor, context);
        visitor.visitJumpInsn(IFEQ, l0);
        statement.getThen().generateByteCode(visitor, context.clone());
        visitor.visitJumpInsn(GOTO, finish);
        visitor.visitLabel(l0);
        statement.getOtherwise().generateByteCode(visitor, context.clone());
        visitor.visitJumpInsn(GOTO, finish);
        visitor.visitLabel(finish);
    }

    public static void generate(TypedLocalVarDeclaration statement, MethodVisitor visitor, Context context) {
        context.getLocalVar().put(statement.getName(), context.getLocalVar().size());
        if(isInteger(statement.getVariableType())) {
            visitor.visitInsn(ICONST_0);
            visitor.visitVarInsn(ISTORE, context.getLocalVar().get(statement.getName()));
        }
    }

    public static void generate(TypedWhile statement, MethodVisitor visitor, Context context) {
        Label finish = new Label();
        Label l0 = new Label();
        visitor.visitLabel(l0);
        statement.getExp().generateByteCode(visitor, context.clone());
        visitor.visitJumpInsn(IFEQ, finish);
        statement.getStmt().generateByteCode(visitor, context.clone());
        visitor.visitJumpInsn(GOTO, l0);
        visitor.visitLabel(finish);
    }

    public static void generate(TypedMethodCallStatement statement, MethodVisitor visitor, Context context) {
        generateMethodCall(statement.getName(), statement.getObjectType(), statement.getObject(),
                statement.getParameters(), visitor, context);
        if(!ObjectType.VoidType.equals(statement.getObjectType())) {
            visitor.visitInsn(POP);
        }
    }

    public static void generate(TypedNewStatement statement, MethodVisitor visitor, Context context) {
        GeneratorUtils.generateNew(statement.getNewType(), statement.getParameters(), visitor, context);
        visitor.visitInsn(POP);
    }

    /**
     * The default implementation for a {@link TypedStatement}
     *
     * @param statement The statement for the bytecode generation
     * @param visitor   The {@link MethodVisitor} of the current method
     * @param context   The {@link Context} of the current scope
     *
     * @throws NotImplementedYetException Always
     */
    public static void generate(TypedStatement statement, MethodVisitor visitor, Context context)
            throws NotImplementedYetException {
        throw new NotImplementedYetException();
    }
}
