import common.Global;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        for(var inputFileName : args)
        {
            try (var file = new FileInputStream(inputFileName))
            {
                System.out.println("Starting generation of ast.");
                var ast = Global.getFactory().getASTGenerator().getAST(file);
                System.out.println("Starting generation of typed ast.");
                var typedAst = Global.getFactory().getTypedAstGenerator().getTypedProgram(ast);
                System.out.println("Generating byte code.");
                var byteCode = Global.getFactory().getBytecodeGenerator().generate(typedAst);
                System.out.println("Starting generation of typed ast.");
                var i = 0;
                for (var m : byteCode)
                {
                    var name = typedAst.getClasses().get(i++).getClassType().getName();
                    try (var os = new FileOutputStream(name, false))
                    {
                        os.write(m.toByteArray());
                    }
                }
            }
        }
    }
}
