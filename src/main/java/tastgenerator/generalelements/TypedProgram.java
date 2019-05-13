package tastgenerator.generalelements;

import java.util.List;

public class TypedProgram extends TypedGeneralThing
{
    private List<TypedClass> classes;

    public List<TypedClass> getClasses()
    {
        return classes;
    }

    public TypedProgram(List<TypedClass> classes) {
        this.classes = classes;
    }
}
