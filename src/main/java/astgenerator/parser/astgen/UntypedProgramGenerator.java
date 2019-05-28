package astgenerator.parser.astgen;

import astgenerator.generalelements.*;
import astgenerator.generalelements.Class;
import astgenerator.parser.generated.awsomeJavaParser;

import java.util.ArrayList;
import java.util.List;

public class UntypedProgramGenerator {


    public UntypedProgram generate(awsomeJavaParser.ProgrammContext programContext) {

        UntypedProgram program = new UntypedProgram();
        List<Class> classes = new ArrayList<>();
        programContext.jClass().forEach(classContext -> classes.add(ClassGenerator.generate(classContext)));
        program.setClasses(classes);
        return program;
    }
}
