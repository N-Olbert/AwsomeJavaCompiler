package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.expressions.InstVar;
import astgenerator.expressions.LocalOrFieldVar;
import astgenerator.parser.generated.awsomeJavaParser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BasicExpressionGenerator {

    static Expression generate(awsomeJavaParser.BasicexpressionsContext basicexpressionsContext){
        if (basicexpressionsContext.baseType() != null){
            return BaseTypeGenerator.generate(basicexpressionsContext.baseType());
        } else if (basicexpressionsContext.instVar() != null){
            return InstVarGenerator.generate(basicexpressionsContext.instVar());
        } else if (basicexpressionsContext.unary() != null){
            return UnaryGenerator.generate(basicexpressionsContext.unary());
        } else { //Identifier
            return new LocalOrFieldVar(basicexpressionsContext.Identifier().getText());
        }
    }

}
