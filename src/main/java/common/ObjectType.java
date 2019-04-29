package common;

public class ObjectType
{

    public static ObjectType IntType = new ObjectType(int.class.toString());
    public static ObjectType BoolType = new ObjectType(boolean.class.toString());
    public static ObjectType CharType = new ObjectType(char.class.toString());
    public static ObjectType StringType = new ObjectType(String.class.toString());
    public static ObjectType VoidType = new ObjectType(Void.class.toString());
    public static ObjectType NullType = new ObjectType("null");


    private String name;

    public ObjectType(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
