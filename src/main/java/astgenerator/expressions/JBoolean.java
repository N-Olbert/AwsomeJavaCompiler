package astgenerator.expressions;

public class JBoolean extends Expression
{
    private boolean jBool;

    public JBoolean(String jBool){
        this.jBool = Boolean.parseBoolean(jBool);
    }

    public boolean getJBool(){
        return jBool;
    }
}
