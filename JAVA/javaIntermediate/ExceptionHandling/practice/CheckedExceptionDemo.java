package javaIntermediate.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionDemo {
    public static void main(String[] args) {
        try {
            method2();
        } catch (FileNotFoundException e) {
            System.out.println("Hello");
            System.out.println(e.getCause());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getStackTrace());
        }
    }

    public static void method2() throws FileNotFoundException {
        method1();
    }

    public static void method1() throws FileNotFoundException {
        FileReader fr = new FileReader("x.txt");
    }
}
