package tastgenerator.exceptions;

public class AlreadyDefinedException extends RuntimeException{
    public AlreadyDefinedException(String errorMessage) {
        super(errorMessage);
    }
}
