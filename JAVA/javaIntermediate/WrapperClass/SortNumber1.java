package javaIntermediate.WrapperClass;

import java.util.Scanner;

public class SortNumber1 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 1st Number: ");
			int a=sc.nextInt();
			System.out.println("ENter the 2nd number: ");
			int b=sc.nextInt();
			if(Integer.compare(a, b)>0) {
				int temp=a;
				a=b;
				b=temp;
			}
			System.out.println(a+" "+b);
		}
	}

}
