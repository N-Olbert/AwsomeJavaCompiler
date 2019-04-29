package astgenerator.generalelements;

import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

public abstract class GeneralThing
{
    public TypedGeneralThing toTyped(TypeChecker converter)
    {
        throw new IllegalStateException("NOPE");
    }
}
