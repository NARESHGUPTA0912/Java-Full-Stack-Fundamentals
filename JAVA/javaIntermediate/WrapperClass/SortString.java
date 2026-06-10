package javaIntermediate.WrapperClass;

import java.util.Scanner;

public class SortString {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 1st String: ");
			String s1=sc.nextLine();
			System.out.println("ENter the 2nd String: ");
			String s2=sc.nextLine();
			if(s1.compareToIgnoreCase(s2)>0) {
				String temp=s1;
				s1=s2;
				s2=temp;
			}
			System.out.println(s1+" "+s2);
		}
	}
}
