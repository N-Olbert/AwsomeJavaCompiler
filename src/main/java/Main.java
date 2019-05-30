import common.Global;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        var inputList = new ArrayList <FileInputStream>()
        {{
            for (var fileName : args)
            {
                add(new FileInputStream(fileName));
            }
        }};

        try (var files = new SequenceInputStream(Collections.enumeration(inputList)))
        {
            System.out.println("Starting generation of ast.");
            var ast = Global.getFactory().getASTGenerator().getAST(files);
            System.out.println("Starting generation of typed ast.");
            var typedAst = Global.getFactory().getTypedAstGenerator().getTypedProgram(ast);
            System.out.println("Generating byte code.");
            var byteCode = Global.getFactory().getBytecodeGenerator().generate(typedAst);
            System.out.println("Starting generation of typed ast.");
            for (var clazz: byteCode)
            {
                saveClass(clazz.toByteArray(), "target/fibonacci.class"); // TODO: Classname for filename
            }
        }
    }

    private static void saveClass(byte[] bytes, String fileName) {
        File file = new File(fileName);

        try(FileOutputStream os = new FileOutputStream(file)) {
            os.write(bytes);
            os.flush();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
