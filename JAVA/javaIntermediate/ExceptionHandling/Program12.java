package javaIntermediate.exceptionHandling;

import java.util.Scanner;

public class Program12 {
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
		}catch(Exception e) {//All exceptions will be caught and handled here in the same way
			System.out.println(e.getMessage());
		}
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println("Program ends");
	}


}
