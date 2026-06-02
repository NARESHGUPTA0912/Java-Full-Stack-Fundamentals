package javaBasics.oop.userInput;

import java.util.Scanner;
class Program8{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the character: ");
		char c=sc.nextLine().charAt(4);  //it will take the 5th character from the string and store in char variable (index starts from 0 to n-1. if we give index more than the string length then it will throw StringIndexOutOfBoundsException)
		System.out.println("You entered: "+c);
	}
}



