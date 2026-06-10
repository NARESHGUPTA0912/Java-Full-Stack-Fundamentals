package javaIntermediate.WrapperClass;
import java.util.*;
public class SortNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1st Number: ");
		int a=sc.nextInt();
		System.out.println("ENter the 2nd number: ");
		int b=sc.nextInt();
		if(Integer.compare(a, b)<=0)
			System.out.println(a+" "+b);
		else
			System.out.println(b+" "+a);

		sc.close();
	}

}
