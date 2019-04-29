package astgenerator.expressions;

public class LocalOrFieldVar extends Expression
{
    private String name;
    public LocalOrFieldVar(String name){
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

}
