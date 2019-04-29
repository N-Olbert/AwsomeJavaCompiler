package astgenerator.expressions;

public class JString extends Expression
{
    private String jString;

    public JString(String jString){
        this.jString = jString;
    }

    public String getJString(){
        return jString;
    }
}
