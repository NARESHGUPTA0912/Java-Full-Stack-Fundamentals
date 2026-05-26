package ExceptionHandling;

public class UnderAgeException extends Exception{

    public UnderAgeException(String msg) {
        super(msg);
    }

    public UnderAgeException() {
    }
    
}
