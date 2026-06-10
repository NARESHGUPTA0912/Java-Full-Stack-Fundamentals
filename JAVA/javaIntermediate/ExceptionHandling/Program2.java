package exceptionHandling;

public class Program2 {
	public static void main(String[] args) {
	
		int a=12;
		int b=0;
		System.out.println("Sum: "+(a+b));
		System.out.println("Difference: "+(a-b));
		try {
			System.out.println("Quotient: "+(a/b));
		} catch (Exception e) {
			System.out.println(e);
			//actions to be taken in case of exception
			//roollback or alternative code
			//ways to handle exception
			System.out.println("b is zero so cannot perform division");
		}
		System.out.println("Product: "+(a*b));
		System.out.println("End of Program");
	}

}
