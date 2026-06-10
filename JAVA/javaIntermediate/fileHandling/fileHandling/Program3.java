package fileHandling;

import java.io.FileReader;

public class Program3 {
	
	public static void main(String[] args) {
		String path="h:\\Factorial.java";
		try {
			FileReader f1=new FileReader(path);
			System.out.println(f1.readAllAsString());
			System.out.println("Reading is completed!");
			f1.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Program Ends!");
		
	}

}
