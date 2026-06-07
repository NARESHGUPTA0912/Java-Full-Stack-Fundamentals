package javaBasics.primitivetypecasting;

public class Program6 {
    public static void main(String[] args) {
        byte a = 10;
        short b = 20;
        byte c = (byte) (a + b);
        short d = (short) (a + b + c);

        // we can store ascii integer on char reference
        char e = (char)(a + b + c + d);  // 120 -> x

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
