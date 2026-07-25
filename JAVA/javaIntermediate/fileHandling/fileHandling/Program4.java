package fileHandling;

import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
class Program4 {
	public static void main(String[] args) throws Exception {
		String path="f:\\user.txt";

		try ( 	Scanner sc1=new Scanner(System.in);
				FileWriter f1=new FileWriter(path, true) ){
				
			f1.write("Mohan is here\n");
			f1.write("Sohan is There\n");
			f1.write("John is Coming\n");
			f1.write("Jack is going\n");
			f1.write(66+"\n");
			System.out.println("Writing is successfully completed!");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Program Ends!");
	}
}
