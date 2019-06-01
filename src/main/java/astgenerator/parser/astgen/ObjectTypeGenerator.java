package astgenerator.parser.astgen;

import astgenerator.parser.generated.awsomeJavaParser;
import common.ObjectType;

public class ObjectTypeGenerator {

    public static ObjectType generate(awsomeJavaParser.ObjectTypeContext objectTypeContext){
        String objectType = objectTypeContext.getText();

        switch (objectType) {
            case "int":
                return ObjectType.IntType;
            case "boolean":
                return ObjectType.BoolType;
            case "char":
                return ObjectType.CharType;
            default:
                return ObjectType.getType(objectType);
        }
    }
}
