package astgenerator.parser.astgen;

import astgenerator.expressions.*;
import astgenerator.parser.generated.awsomeJavaParser;

public class BaseTypeGenerator {

    public static Expression generate(awsomeJavaParser.BaseTypeContext context){

        if (context.JBoolean() != null){
            return new JBoolean(context.JBoolean().getText());
        } else if (context.JCharacter() != null){
            return new JCharacter(context.JCharacter().getText());
        } else if (context.JString() != null){
            return new JString(context.JString().getText());
        } else if (context.JNull() != null){
            return new JNull();
        } else if (context.Super() != null) {
            return new Super();
        } else if (context.JInteger() != null){
            return new JInteger(context.JInteger().getText());
        } else {
            return new This();
        }

    }
}
