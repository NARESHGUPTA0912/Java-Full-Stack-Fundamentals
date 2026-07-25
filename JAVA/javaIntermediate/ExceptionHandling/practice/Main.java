package javaIntermediate.exceptionHandling.practice;

public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Prince", 686466216, 32000.90);
        Bank b = new Bank();
        b.enrollCustomer(c);
        try {
            b.withdraw(35000);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
        System.out.println("Amount: " + c.getBalance());
    }
}
