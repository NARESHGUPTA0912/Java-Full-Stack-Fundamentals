package javaIntermediate.exceptionHandling;

public class NoSuchEmployeeFoundException extends Exception{

    public NoSuchEmployeeFoundException(String message) {
        super(message);
    }

    public NoSuchEmployeeFoundException() {
    }
    
}