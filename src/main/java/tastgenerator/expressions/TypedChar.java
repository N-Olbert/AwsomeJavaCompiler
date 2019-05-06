package tastgenerator.expressions;


import bytecodegenerator.Generator;
import common.ObjectType;
import org.objectweb.asm.MethodVisitor;

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
    public void generateByteCode(MethodVisitor visitor) {
        Generator.generate(this, visitor);
    }
}
