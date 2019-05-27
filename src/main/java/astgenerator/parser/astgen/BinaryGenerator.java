package astgenerator.parser.astgen;

import astgenerator.expressions.Binary;
import astgenerator.expressions.Expression;
import astgenerator.parser.generated.awsomeJavaParser;
import bytecodegenerator.Generator;
import common.Operators;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.antlr.v4.runtime.atn.SemanticContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.ibm.icu.util.LocalePriorityList.add;

public class BinaryGenerator {

    private static ArrayList<List<String>> operatorTypes;

    public static Binary generate(awsomeJavaParser.BinaryContext binaryContext){
        operatorTypes = new ArrayList<>();
        operatorTypes.add(Collections.singletonList("||")); //OR
        operatorTypes.add(Collections.singletonList("&&")); //AND
        operatorTypes.add(Collections.singletonList("^")); //XOR
        operatorTypes.add(Arrays.asList(new String[]{"==","!="})); //EQUALS
        operatorTypes.add(Arrays.asList(new String[]{">=",">","<=","<"})); //COMPARATOR
        operatorTypes.add(Arrays.asList(new String[]{"*","/"})); //POINT
        operatorTypes.add(Arrays.asList(new String[]{"+","-"})); //ADDSUB


        List <String> operators = new ArrayList<>();
        binaryContext.operators().forEach(operatorsContext -> operators.add(operatorsContext.getText()));
        List<Expression> expressions = new ArrayList<>();
        for (awsomeJavaParser.BasicexpressionsContext basicExpression: binaryContext.basicexpressions()) {
            expressions.add(BasicExpressionGenerator.generate(basicExpression));
        }
        return operatorSplit(expressions, operators);
    }

    private static Binary operatorSplit(List<Expression> expressions, List<String> operators) {
        for (List<String> operatortype: operatorTypes) {
            List<Expression> newExpressions = new ArrayList<>();
            List<String> newOperators = new ArrayList<>();
            for (int i = 0; i < operators.size(); i++) {
                if (operatortype.contains(operators.get(i))) {
                    if (!newExpressions.isEmpty()) {
                        newExpressions.remove(expressions.size() - 1);
                    }
                    newExpressions.add(new Binary(expressions.get(i), expressions.get(i + 1), getoperatorFromString(operators.get(i))));
                } else {
                    newExpressions.add(expressions.get(i + 1));
                    newOperators.add(operators.get(i));
                }
            }
            expressions = newExpressions;
            operators = newOperators;
        }
        return (Binary) expressions.get(0);
    }

    private static Operators getoperatorFromString(String operator) {
        switch(operator) {
            case "||":
                return Operators.OR;
            case "&&":
                return Operators.AND;
            case "^":
                return Operators.XOR;
            case "==":
                return Operators.EQUALS;
            case "!=":
                return Operators.NOTEQUALS;
            case ">=":
                return Operators.GREATEROREQUAL;
            case ">":
                return Operators.GREATERTHAN;
            case "<=":
                return Operators.LESSOREQUAL;
            case "<":
                return Operators.LESSTHAN;
            case "*":
                return Operators.MULTIPLICATION;
            case "/":
                return Operators.DIVISION;
            case "+":
                return Operators.PLUS;
            case "-":
                return Operators.MINUS;
            default:
                return null;
        }
    }
}
