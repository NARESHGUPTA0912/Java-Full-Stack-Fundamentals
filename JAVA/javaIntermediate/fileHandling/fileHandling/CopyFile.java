package fileHandling;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {
	public static void main(String[] args) {
		System.out.println("======File Reading STarts======");
		
		try(FileReader fr=new FileReader("f:\\AppUser.txt");
			FileWriter fw=new FileWriter("f:\\CopyOfAppUser.txt");
		){
			
			int x=fr.read();
			while(x!=-1) {
				fw.write(x);
				x=fr.read();
			}
			System.out.println("======File Copy Completed======");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
