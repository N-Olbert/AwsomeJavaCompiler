package common;

import org.objectweb.asm.Opcodes;

public enum Modifier
{
    NONE(0),
    STATIC(Opcodes.ACC_FINAL),
    ABSTRACT(Opcodes.ACC_ABSTRACT),
    FINAL(Opcodes.ACC_FINAL);

    private int code;

    Modifier(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
