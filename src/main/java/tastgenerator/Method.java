package tastgenerator;

import common.ObjectType;

import java.util.List;

public class Method {

    ObjectType returnType;
    List<ObjectType> params;

    public Method(ObjectType returnType, List<ObjectType> params) {
        this.returnType = returnType;
        this.params = params;
    }

    public ObjectType getReturnType() {
        return returnType;
    }

    public List<ObjectType> getParams() {
        return params;
    }
}
