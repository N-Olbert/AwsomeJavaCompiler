package tastgenerator;

import common.ObjectType;

import java.util.HashMap;
import java.util.List;

public class ClassObject {
    private HashMap<String, ObjectType> fields;
    private HashMap<String, List<Method>> methods;

    public ClassObject(HashMap<String, ObjectType> fields, HashMap<String, List<Method>> methods) {
        this.fields = fields;
        this.methods = methods;
    }

    public HashMap<String, ObjectType> getFields() {
        return fields;
    }

    public HashMap<String, List<Method>> getMethods() {
        return methods;
    }

}
