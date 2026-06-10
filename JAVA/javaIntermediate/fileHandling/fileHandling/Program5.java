package fileHandling;
import java.io.FileReader;
public class Program5 {
	public static void main(String[] args) {
		System.out.println("======File Reading STarts======");
		
		try(FileReader fr=new FileReader("f:\\AppUser.txt");	
		){
			int x=fr.read();
			while(x!=-1) {
				System.out.print((char)x);
				x=fr.read();
			}
			System.out.println("======File Reading Completed======");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
