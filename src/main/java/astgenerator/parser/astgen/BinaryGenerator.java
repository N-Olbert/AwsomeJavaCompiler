package astgenerator.parser.astgen;

import astgenerator.expressions.Binary;
import astgenerator.expressions.Expression;
import astgenerator.parser.generated.awsomeJavaParser;
import common.Operators;
import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryGenerator {

    private static HashMap<String,String[]> operatorTypes;

    public static void generate(awsomeJavaParser.BinaryContext binaryContext){
        operatorTypes = new HashMap<>();
        operatorTypes.put("OR",new String[]{"||"});
        operatorTypes.put("AND",new String[]{"&&"});
        operatorTypes.put("XOR",new String[]{"^"});
        operatorTypes.put("EQUALITY",new String[]{"==","!="});
        operatorTypes.put("COMPERATOR", new String[]{">=",">","<=","<"});
        operatorTypes.put("ADDSUB",new String[]{"+","-"});
        operatorTypes.put("POINT", new String[]{"*","/"};


        List <String> operators = new ArrayList<>();
        binaryContext.operators().forEach(operatorsContext -> operators.add(operatorsContext.getText()));
        List<awsomeJavaParser.BasicexpressionsContext> expressions = binaryContext.basicexpressions();

    }

    private Expression operatorSplit(Operators operator, List<String> operators,
                                     List<awsomeJavaParser.BasicexpressionsContext> expressions){

    }
}
