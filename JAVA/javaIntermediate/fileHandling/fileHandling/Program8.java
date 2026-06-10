package javaIntermediate.fileHandling.fileHandling;
import java.io.*;
public class Program8 {
	public static void main(String[] args) throws IOException {
		
		
		File file=new File("f:\\AppUser.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		FileInputStream fis=new FileInputStream(file);
		
		BufferedInputStream bis=new BufferedInputStream(fis);
		
		String line=br.readLine();
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		
		
	}

}
