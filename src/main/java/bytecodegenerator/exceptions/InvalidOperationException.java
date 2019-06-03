package bytecodegenerator.exceptions;

import common.Operators;

/**
 * The InvalidOperationException can be thrown if a {@link tastgenerator.expressions.TypedUnary} or {@link
 * tastgenerator.expressions.TypedBinary} has an invalid operator or the wrong type
 *
 * @author Nico Dreher
 */
public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(Operators operator) {
        super("Invalid Operation: " + operator.toString());
    }
}
