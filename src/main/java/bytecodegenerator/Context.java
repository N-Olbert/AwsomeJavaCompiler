package bytecodegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context implements Cloneable {
    private String className;
    private Map<String, Integer> localVar;
    private List<String> localFields;
    private List<String> staticFields;

    public Context(String className) {
        this.className = className;
        this.localVar = new HashMap<>();
        this.localFields = new ArrayList<>();
        this.staticFields = new ArrayList<>();
    }

    public Context(String className, Map<String, Integer> localVar, List<String> localFields, List<String> staticFields) {
        this.className = className;
        this.localVar = localVar;
        this.localFields = localFields;
        this.staticFields = staticFields;
    }

    public String getClassName() {
        return className;
    }

    public Map<String, Integer> getLocalVar() {
        return localVar;
    }

    public List<String> getLocalFields() {
        return localFields;
    }

    public List<String> getStaticFields() {
        return staticFields;
    }

    @Override
    public Context clone() {
        return new Context(className, new HashMap<>(localVar), new ArrayList<>(localFields), new ArrayList<>(staticFields));
    }

}
