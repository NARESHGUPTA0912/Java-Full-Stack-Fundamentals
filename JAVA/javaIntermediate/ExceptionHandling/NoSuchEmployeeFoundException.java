package ExceptionHandling;

public class NoSuchEmployeeFoundException extends Exception{

    public NoSuchEmployeeFoundException(String message) {
        super(message);
    }

    public NoSuchEmployeeFoundException() {
    }
    
}