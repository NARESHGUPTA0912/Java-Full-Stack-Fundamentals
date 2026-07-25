package javaIntermediate.exceptionHandling;

public class Program1 {
	public static void main(String[] args) {
		int a=12;
		int b=0;
		System.out.println("Sum: "+(a+b));
		System.out.println("Difference: "+(a-b));
		
		if(b!=0) {
			System.out.println("Quotient: "+(a/b));
		}else {
			
			System.out.println("b is zero so cannot perform division");
		}
		System.out.println("product is: "+(a*b));
		System.out.println("End of Program");
	}

}
