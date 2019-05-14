package tastgenerator.exceptions;

public class CannotResolveSymbolException extends RuntimeException{
    public CannotResolveSymbolException(String errorMessage) {
        super(errorMessage);
    }
}
