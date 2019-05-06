package astgenerator.generalelements;

import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

import java.util.ArrayList;
import java.util.List;

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
}
