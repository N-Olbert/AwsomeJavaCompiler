package common;

import java.util.HashMap;
import java.util.Map;

public class ObjectType
{
    public static Map<String, ObjectType> typeMap = new HashMap<String, ObjectType>();
    public static ObjectType IntType = new ObjectType(int.class.toString());
    public static ObjectType BoolType = new ObjectType(boolean.class.toString());
    public static ObjectType CharType = new ObjectType(char.class.toString());
    public static ObjectType StringType = new ObjectType(String.class.toString());
    public static ObjectType VoidType = new ObjectType(Void.class.toString());
    public static ObjectType NullType = new ObjectType("null");


    private String name;

    public static ObjectType getType(String name)
    {
        if(!typeMap.containsKey(name))
        {
            typeMap.put(name, new ObjectType(name));
        }

        return typeMap.get(name);
    }

    private ObjectType(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof ObjectType)
        {
            return this.name.equals(((ObjectType) obj).name);
        }

        return false;
    }
}
