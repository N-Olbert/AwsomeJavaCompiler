package astgenerator.parser.astgen;

import common.Operators;
import org.antlr.v4.runtime.tree.TerminalNode;

public class OperatorGenerator {

    public static Operators generate(TerminalNode operator){
        switch (operator.getText()){
            case "+":
                return Operators.PLUS;
            case "-":
                return Operators.MINUS;
            case "*":
                return Operators.MULTIPLICATION;
            case "/":
                return Operators.DIVISION;
            case "%":
                return Operators.MODULO;
            case "&&":
                return Operators.AND;
            case "||":
                return Operators.OR;
            case "^":
                return Operators.XOR;
            case "!":
                return Operators.NEGATION;
            case "==":
                return Operators.EQUALS;
            case "!=":
                return Operators.NOTEQUALS;
            case ">=":
                return Operators.GREATEROREQUAL;
            case "<=":
                return Operators.LESSOREQUAL;
            case  ">":
                return Operators.GREATERTHAN;
            default: //"<"
                return Operators.LESSTHAN;
        }
    }

}
