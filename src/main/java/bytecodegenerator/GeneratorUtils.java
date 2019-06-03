package bytecodegenerator;

import bytecodegenerator.exceptions.NotImplementedYetException;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;
import tastgenerator.expressions.TypedExpression;
import tastgenerator.expressions.TypedInstVar;
import tastgenerator.expressions.TypedLocalOrFieldVar;

import java.util.List;
import java.util.stream.Collectors;

import static org.objectweb.asm.Opcodes.*;

/**
 * The GeneratorUtils class contains some utility functions for the bytecode generation
 *
 * @author Nico Dreher
 */
public class GeneratorUtils {

    /**
     * Get the type signature of function parameters
     *
     * @param types The list of the {@link ObjectType} from the parameters
     *
     * @return The type signature of the parameters
     */
    public static String generateTypeSignature(List<ObjectType> types) {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        types.forEach(type -> builder.append(geTypeSignatureName(type)));
        builder.append(')');
        return builder.toString();
    }


    /**
     * Get the load {@link org.objectweb.asm.Opcodes} by the {@link ObjectType}
     *
     * @param type The {@link ObjectType} to load
     *
     * @return the needed opcode
     */
    public static int getOpcodeLoad(ObjectType type) {
        if(isInteger(type)) {
            return ILOAD;
        }
        else {
            return ALOAD;
        }
    }


    /**
     * Checks if a {@link ObjectType} has the integer type
     *
     * @param type The type to check
     *
     * @return True if the ObjectType is a integer type
     */
    public static boolean isInteger(ObjectType type) {
        return "I".equals(type.getName()) || "C".equals(type.getName()) || "Z".equals(type.getName());
    }

    public static void generateAssign(TypedExpression expression1, TypedExpression expression2, MethodVisitor visitor,
                                      Context context) {
        if(expression1 instanceof TypedInstVar) {
            ((TypedInstVar) expression1).getExpression().generateByteCode(visitor, context);
            expression2.generateByteCode(visitor, context);
            visitor.visitFieldInsn(PUTFIELD, context.getClassName(),
                    ((TypedInstVar) expression1).getName(),
                    getTypeName(expression2.getObjectType()));
        }
        else if(expression1 instanceof TypedLocalOrFieldVar) {
            TypedLocalOrFieldVar lofv = (TypedLocalOrFieldVar) expression1;
            if(context.getLocalVar().containsKey(lofv.getName())) {
                expression2.generateByteCode(visitor, context);
                if(isInteger(expression1.getObjectType())) {
                    visitor.visitVarInsn(ISTORE, context.getLocalVar().get(lofv.getName()));
                }
                else {
                    visitor.visitVarInsn(ASTORE, context.getLocalVar().get(lofv.getName()));
                }
            }
            else if(context.getLocalFields().contains(lofv.getName())) {
                visitor.visitVarInsn(ALOAD, 0);
                expression2.generateByteCode(visitor, context);
                visitor.visitFieldInsn(PUTFIELD, context.getClassName(), lofv.getName(),
                        getTypeName(lofv.getObjectType()));
            }
            else {
                throw new NotImplementedYetException();
            }
        }
        else {
            throw new NotImplementedYetException();
        }
    }

    public static void generateNew(ObjectType type, List<TypedExpression> params, MethodVisitor visitor,
                                   Context context) {
        visitor.visitTypeInsn(NEW, getTypeName(type));
        visitor.visitInsn(DUP);
        params.forEach(param -> param.generateByteCode(visitor, context));
        visitor.visitMethodInsn(INVOKESPECIAL, getTypeName(type), "<init>",
                generateTypeSignature(params.stream().map(TypedExpression::getObjectType).collect(
                        Collectors.toList())) + "V", false);
    }

    public static void generateMethodCall(String name, ObjectType type, TypedExpression object,
                                          List<TypedExpression> params,
                                          MethodVisitor visitor, Context context) {

        String signature =
                generateTypeSignature(params.stream().map(TypedExpression::getObjectType).collect(
                        Collectors.toList())) +
                        geTypeSignatureName(type);
        object.generateByteCode(visitor, context);
        params.forEach(exp -> exp.generateByteCode(visitor, context));
        visitor.visitMethodInsn(INVOKEVIRTUAL, getTypeName(object.getObjectType()),
                name, signature, false);
    }

    public static String geTypeSignatureName(ObjectType type) {
        if("I".equals(getTypeName(type)) || "Z".equals(getTypeName(type)) || "C".equals(getTypeName(type)) ||
                "V".equals(getTypeName(type))) {
            return getTypeName(type);
        }
        else {
            return "L" + getTypeName(type) + ";";
        }
    }

    public static String getTypeName(ObjectType type) {
        return ObjectType.JObjectType.equals(type) ? Object.class.getName().replace('.', '/') :
                type.getName().replace('.', '/');
    }


}
