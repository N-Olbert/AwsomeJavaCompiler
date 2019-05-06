package tastgenerator.exceptions;

public class TypeMismatchException extends RuntimeException{
    public TypeMismatchException(String errorMessage) {
        super(errorMessage);
    }
}
