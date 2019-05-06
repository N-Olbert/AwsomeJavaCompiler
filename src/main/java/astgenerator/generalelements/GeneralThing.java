package astgenerator.generalelements;

import tastgenerator.TypeChecker;
import tastgenerator.generalelements.TypedGeneralThing;

public abstract class GeneralThing
{
    public abstract TypedGeneralThing toTyped(TypeChecker converter);
}
