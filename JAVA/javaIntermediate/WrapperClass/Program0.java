package javaIntermediate.WrapperClass;

public class Program0 {
    public static void main(String[] args) {
        int x = 1; 
        Integer a = Integer.valueOf(x);   // unnecessary boxing
        Integer a2 = x; // auto-boxing
        int b = a.intValue(); // uunecessary unboxing
        int b2 = a2; // auto-unboxing

        System.out.println(a);
        System.out.println(a2);
        System.out.println(b);
        System.out.println(b2);
    }
}
