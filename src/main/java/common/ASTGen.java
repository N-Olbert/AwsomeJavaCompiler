package common;

import astgenerator.generalelements.UntypedProgram;
import astgenerator.parser.ParseTreeGenerator;
import astgenerator.parser.generated.awsomeJavaLexer;
import astgenerator.parser.generated.awsomeJavaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.io.InputStream;

public class ASTGen implements ASTGenerator {
    @Override
    public UntypedProgram getAST(InputStream stream) {
        CharStream cstream = null;
        try {
            cstream = CharStreams.fromStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        awsomeJavaLexer lexer = new awsomeJavaLexer(cstream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        awsomeJavaParser parser = new awsomeJavaParser(tokens);
        ParseTreeGenerator generator = new ParseTreeGenerator();

        return new ParseTreeGenerator().generate(parser.programm());
    }
}
