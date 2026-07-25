package javaIntermediate.exceptionHandling;

import java.util.Scanner;

public class Program13 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a:");
		int a=sc.nextInt();
		System.out.println("Enter b:");
		int b=sc.nextInt();
		System.out.println("Enter index:");
		int index=sc.nextInt();
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.println(a+"-"+b+"="+(a-b));
		try {
			System.out.println(a+"/"+b+"="+(a/b));
			System.out.println("abc".charAt(index));
			System.out.println("Inside try block");
		}catch(ArithmeticException e) {
			System.out.println("Division by zero is not allowed");
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("String index is out of range");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println("Program ends");
	}

}
