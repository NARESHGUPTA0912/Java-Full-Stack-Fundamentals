package fileHandling;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class App {
	public static void main(String[] args) {
		System.out.println("Welcome to App");
		System.out.println("Please Enter details for registration");
		File path=new File("f:\\AppUser.txt");
		path.setWritable(true);
		try(Scanner sc=new Scanner(System.in);
			FileWriter fw=new FileWriter(path, true);
		){
			System.out.println("Enter your Name: ");
			String name=sc.nextLine();
			System.out.println("Enter your Email: ");
			String email=sc.nextLine();
			System.out.println("Enter your Age: ");
			String age=sc.nextLine();
			fw.write("Name is: "+name+"\n");
			fw.write("Email is: "+email+"\n");
			fw.write("Age is: "+age+"\n");
			fw.write("------------------------\n");
			System.out.println("Registration is completed!");
		}catch(Exception e) {
			System.out.println("catch block executed");
			System.out.println(e.getMessage());
		}
	}

}
