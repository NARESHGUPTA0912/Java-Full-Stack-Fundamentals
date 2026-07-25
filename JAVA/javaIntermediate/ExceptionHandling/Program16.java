package javaIntermediate.exceptionHandling;

import java.util.Scanner;

public class Program16 {
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
			for(int i=0;i>=0;i++) {
				System.out.println(i);
			}
		}catch(ArithmeticException | StringIndexOutOfBoundsException e) {
			System.out.println("Arithmetic or String Index Exception occurred");
			//code
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Inside finally block");
			sc.close();
			System.out.println("Scanner closed");
		}
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println("Program ends");
	}

}
