package javaIntermediate.exceptionHandling.practice;

public class Customer {
    String customerName;
    long accountNo;
    double balance;

    public Customer() {
    }

    public Customer(String customerName, long accountNo, double balance) {
        this.customerName = customerName;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

}
