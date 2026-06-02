package javaBasics.primitivetypecasting;

public class Program4 {
    public static void main(String[] args) {
        byte a = 45;
        byte b = 30;
        System.out.println("Sum is: " + (a + b)); // valid
        a += b; // no need to cast, it is valid
        System.out.println("Sum is: " + a);
    }
}
