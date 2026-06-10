package exceptionHandling.customException;

public class Program2 {
	public static void main(String[] args) {
		int[] a= {13, 41, 57, 61, 87, 93};
		try {
				int elem=getFirstEven(a);
				System.out.println("Square of element is: "+elem*elem);
		}catch(NoSuchElementsFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("========Program Ends==========");
	}
	
	public static int getFirstEven(int[] a) throws NoSuchElementsFoundException, ArithmeticException {
		for(int i=0;i<a.length;i++) {
			if(a[i]%2==0)
				return a[i];
		}
	throw new NoSuchElementsFoundException("First Even Not Found");
	}

}
