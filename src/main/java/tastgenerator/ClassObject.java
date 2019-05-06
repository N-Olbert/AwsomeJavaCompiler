package tastgenerator;

import common.ObjectType;

import java.util.HashMap;

public class ClassObject {
    private HashMap<String, ObjectType> fields;
    private HashMap<String, Method> methods;

    public ClassObject(HashMap<String, ObjectType> fields, HashMap<String, Method> methods) {
        this.fields = fields;
        this.methods = methods;
    }

    public HashMap<String, ObjectType> getFields() {
        return fields;
    }

    public HashMap<String, Method> getMethods() {
        return methods;
    }

}
