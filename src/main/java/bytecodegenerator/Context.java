package bytecodegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Context type is used to store and change the visible variables of the current scope
 *
 * @author Nico Dreher
 */
public class Context implements Cloneable {
    /**
     * The name of the class, which is currently generating
     */
    private String className;
    /**
     * The map of all visible local variables and the position in the storage
     */
    private Map<String, Integer> localVar;
    /**
     * The list of all local fields
     */
    private List<String> localFields;
    /**
     * The list of all static fields
     */
    private List<String> staticFields;

    public Context(String className) {
        this.className = className;
        this.localVar = new HashMap<>();
        this.localFields = new ArrayList<>();
        this.staticFields = new ArrayList<>();
    }

    public Context(String className, Map<String, Integer> localVar, List<String> localFields,
                   List<String> staticFields) {
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

    /**
     * Creates a clone of the current context and all child objects.
     *
     * @return the clone of the context
     */
    @Override
    public Context clone() {
        return new Context(className, new HashMap<>(localVar), new ArrayList<>(localFields),
                new ArrayList<>(staticFields));
    }

}
