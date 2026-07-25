package javaIntermediate.exceptionHandling.practice;

public class Bank {

    Customer cust;
    public String enrollCustomer(Customer c){
        cust = c;
        return "Customer enrolled successfully";
    }
    
    public String withdraw(double amount) throws InsufficientFundsException {
        double balance = cust.getBalance();
        if(amount > balance) {
            //throw new InsufficientFundsException("Insufficient Withdrawal Amount");
        } else {
            System.out.println("Total Amount: " + balance);
            System.out.println("Withdrawal Amount: " + amount);
            balance = balance - amount;
            cust.setBalance(balance);
            System.out.println("Remaining Balance: " + balance);
        }
        return "Amount Withdrawal Successfully";
    }
}
