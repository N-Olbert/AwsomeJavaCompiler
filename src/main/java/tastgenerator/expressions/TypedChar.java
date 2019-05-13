package tastgenerator.expressions;


import bytecodegenerator.Context;
import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;

public class TypedChar extends TypedExpression
{
    private char jChar;

    public TypedChar(String jChar){
        this.jChar = jChar.charAt(0);
        this.objectType = ObjectType.CharType;
    }

    public char getJChar(){
        return jChar;
    }

    @Override
    public void generateByteCode(MethodVisitor visitor, Context context) {
        Generator.generate(this, visitor, context);
    }
}
