package exceptionHandling;
import java.io.*;
public class Program9 {
	public static void main(String[] args) {
		File f1=new File("f:\\abc.txt");
		
		try {
			f1.createNewFile();
			System.out.println("File is Created!!");
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("File is NOT Created!!");
		}
		System.out.println("====Application Ends=====");
		
	}

}
