package javaIntermediate.exceptionHandling;

public class Program10 {
	public static void main(String[] args) {
		System.out.println("Program starts");
		//System.out.println(10/0);
		throw new ArithmeticException("Division by zero is not allowed");
		
	}

}
