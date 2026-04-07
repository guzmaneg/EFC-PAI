package exceptions;

public class EdadInvalidaException extends Exception {
    public EdadInvalidaException() {
        super();
    }
    
    public EdadInvalidaException(String message) {
        super(message);
    }
}
