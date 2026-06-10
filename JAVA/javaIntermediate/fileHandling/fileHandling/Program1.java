package fileHandling;
import java.io.File;
public class Program1 {
	public static void main(String[] args) {
		String path="f:\\abc.txt";
		File f1=new File(path);
		f1.setWritable(false);
		try {
			f1.createNewFile();
			System.out.println("File is Created!");
		}catch(Exception e) {
			System.out.println("File is NOT Craeted!");
			System.out.println(e.getMessage());
		}
		System.out.println("Program Ends!!");
		
	}

}
