package tastgenerator;

import common.AccessModifier;
import common.ObjectType;

import java.util.List;

public class Method {

    ObjectType returnType;
    List<ObjectType> params;
    AccessModifier accessModifier;

    public Method(ObjectType returnType, List<ObjectType> params, AccessModifier accessModifier) {
        this.returnType = returnType;
        this.params = params;
        this.accessModifier = accessModifier;
    }

    public ObjectType getReturnType() {
        return returnType;
    }

    public List<ObjectType> getParams() {
        return params;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }
}
