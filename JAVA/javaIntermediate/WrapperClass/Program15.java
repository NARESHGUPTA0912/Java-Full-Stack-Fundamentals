package javaIntermediate.WrapperClass;

public class Program15 {
    public static void main(String[] args) {
        int x =520;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toHexString(x));
        System.out.println(Integer.toOctalString(x));
        System.out.println("===========================");
        System.out.println(Integer.toString(x,6)); // conversion with num, base
        System.out.println(Integer.toString(x,2));
        System.out.println(Integer.toString(x,8));
        System.out.println(Integer.toString(x,16));
    }
}
