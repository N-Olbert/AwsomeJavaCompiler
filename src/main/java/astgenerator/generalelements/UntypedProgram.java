package astgenerator.generalelements;

import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UntypedProgram extends GeneralThing
{
    private List<Class> classes;
    public List<Class> getClasses()
    {
        return classes;
    }

    public UntypedProgram()
    {
        this.classes = new ArrayList<>();
    }

    public void setClasses(List<Class> classes)
    {
        this.classes = classes;
    }

    @Override
    public TypedGeneralThing toTyped(TypeChecker converter) {
        return converter.typeCheck(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UntypedProgram that = (UntypedProgram) o;
        return Objects.equals(classes, that.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classes);
    }
}
