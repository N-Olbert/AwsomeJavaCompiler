package common;

import java.util.HashMap;
import java.util.Map;

public class ObjectType {
    public static Map<String, ObjectType> typeMap = new HashMap<String, ObjectType>();
    public static ObjectType IntType = new ObjectType("I");
    public static ObjectType BoolType = new ObjectType("Z");
    public static ObjectType CharType = new ObjectType("C");
    public static ObjectType VoidType = new ObjectType("V");
    public static ObjectType NullType = new ObjectType("null");
    public static ObjectType JObjectType = new ObjectType(Object.class.toString());


    private String name;

    private ObjectType(String name) {
        this.name = name;
    }

    public static ObjectType getType(String name) {
        if(!typeMap.containsKey(name)) {
            typeMap.put(name, new ObjectType(name));
        }

        return typeMap.get(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ObjectType) {
            return this.name.equals(((ObjectType) obj).name);
        }

        return false;
    }
}
