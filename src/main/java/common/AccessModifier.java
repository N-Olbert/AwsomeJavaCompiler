package common;

import org.objectweb.asm.Opcodes;

public enum AccessModifier
{
    PRIVATE(Opcodes.ACC_PRIVATE),
    PUBLIC(Opcodes.ACC_PUBLIC),
    PROTECTED(Opcodes.ACC_PROTECTED),
    PACKAGE_PRIVATE(0);
    private int code;
    AccessModifier(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
