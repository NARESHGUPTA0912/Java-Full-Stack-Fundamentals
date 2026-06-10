package fileHandling;

import java.io.FileReader;

public class Program7 {
	public static void main(String[] args) {
		System.out.println("======File Reading STarts======");
		
		try(FileReader fr=new FileReader("f:\\AppUser.txt");	
		){
			int count=0;
			int x=fr.read();
			while(x!=-1) {
				if(x>=48 && x<=57) {
					count++;
				}
				x=fr.read();
			}
			System.out.println("Total Digits in File: "+count);
			System.out.println("======File Reading Completed======");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
