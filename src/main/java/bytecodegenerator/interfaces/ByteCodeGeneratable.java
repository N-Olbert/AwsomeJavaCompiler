package bytecodegenerator.interfaces;

import bytecodegenerator.Context;
import org.objectweb.asm.MethodVisitor;

/**
 * The ByteCodeGeneratable interface is used for elements in the typed abstract syntax tree
 */
public interface ByteCodeGeneratable {
    /**
     * The generateByteCode Function generates the bytecode für a element of the typed abstract syntax tree
     *
     * @param visitor The {@link MethodVisitor} of the currently generating method
     * @param context The {@link Context} of the current scope
     */
    void generateByteCode(MethodVisitor visitor, Context context);
}
