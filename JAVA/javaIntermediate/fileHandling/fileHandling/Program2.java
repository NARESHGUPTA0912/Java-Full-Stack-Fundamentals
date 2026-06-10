package fileHandling;

import java.io.FileWriter;

public class Program2 {
	public static void main(String[] args) throws Exception {
		String path="k:\\user.txt";
		FileWriter f1=null;
		try {
			f1=new FileWriter(path, true);
			f1.write("Mohan is here\n");
			f1.write("Sohan is There\n");
			f1.write("John is Coming\n");
			f1.write(66+"\n");
			System.out.println("Writing is successfully completed!");
			f1.flush();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("finally starts");
			//code for resource closing]
			f1.close();
			System.out.println("finally ends");
		}
		System.out.println("Program Ends!");
		
	}

}
