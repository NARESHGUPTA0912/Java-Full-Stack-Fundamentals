package javaBasics.userInput;

import java.util.Scanner;
class Case2{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Age: ");
		int age=sc.nextInt(); // exception occurs because of nextInt() method, it does not consume the new line character after taking the input, so we need to consume that new line character before taking the next input.
		System.out.println("Enter the Name: "); 
		sc.nextLine();
		String name=sc.nextLine();
		
		System.out.println("======You Entered======");
		System.out.println("Name is: "+name);
		System.out.println("Age is: "+age+"Years");
	}	
}



