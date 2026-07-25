package javaIntermediate.exceptionHandling.practice;

public class InsufficientFundsException extends Exception {

    double amount;

    // public InsufficientFundsException(String message) {
    //     super(message);
    // }
    public InsufficientFundsException(double amount) {
        super("Insufficient Withdrawal!");
        this.amount = amount;
    }

    public InsufficientFundsException() {
    }

    public double getAmount(){
        return amount;
    }

    @Override
    public String toString(){
        return this.getMessage();
    }

}
