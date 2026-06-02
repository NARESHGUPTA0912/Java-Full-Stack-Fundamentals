package javaBasics.primitivetypecasting;

public class Program5 {
    public static void main(String[] args) {
        short a = 50;
        short b = 29;
        System.out.println("Sum is: " + (a + b)); // valid
        a += b; // no need to cast, it is valid
        System.out.println("Sum is: " + a);
    }
}
