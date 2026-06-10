package fileHandling;

import java.io.File;
import java.io.FileReader;

public class Program6 {
	public static void main(String[] args) {
		System.out.println("======File Reading STarts======");
		File file=new File("f:\\AppUser.txt");
		
		try(FileReader fr=new FileReader(file);	
		){
			int x=fr.read();
			System.out.println((char)x);
			System.out.println("======File Reading Completed======");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
