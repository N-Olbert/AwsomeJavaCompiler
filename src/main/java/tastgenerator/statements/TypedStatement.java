package tastgenerator.statements;

import bytecodegenerator.interfaces.ByteCodeGeneratable;
import common.ObjectType;

public abstract class TypedStatement implements ByteCodeGeneratable {
    protected ObjectType objectType;

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        TypedStatement that = (TypedStatement) o;

        return objectType != null ? objectType.equals(that.objectType) : that.objectType == null;

    }

    @Override
    public int hashCode() {
        return objectType != null ? objectType.hashCode() : 0;
    }
}
