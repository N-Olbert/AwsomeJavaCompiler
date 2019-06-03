package bytecodegenerator.exceptions;

/**
 * The NotImplementedYetException can be thrown to indicate that the bytecode generator of an an element is not fully
 * implemented yet
 *
 * @author Nico Dreher
 */
public class NotImplementedYetException extends RuntimeException {
    public NotImplementedYetException() {
        super("Not implemented yet!");
    }
}
