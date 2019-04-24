package tastgenerator.generalelements;

public class ObjectType
{

    public static ObjectType IntType = new ObjectType(Integer.class.toString());
    public static ObjectType BoolType = new ObjectType(Boolean.class.toString());
    public static ObjectType CharType = new ObjectType(Character.class.toString());
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
