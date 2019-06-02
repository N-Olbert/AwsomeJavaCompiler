package bytecodegenerator.exceptions;

import common.Operators;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(Operators operator) {
        super("Invalid Operation: " + operator.toString());
    }
}
