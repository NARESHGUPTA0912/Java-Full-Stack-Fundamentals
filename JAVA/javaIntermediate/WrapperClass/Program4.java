package javaIntermediate.WrapperClass;

public class Program4 {
	public static void main(String[] args) {
		Integer a=500;
		Integer b=500;
		System.out.println(a==b);
		System.out.println(a.equals(b));
		System.out.println("=============");
		Integer p=100;
		Integer q=100;
		System.out.println(p==q); // Object caching
		System.out.println(p.equals(q));
		
	}

}
