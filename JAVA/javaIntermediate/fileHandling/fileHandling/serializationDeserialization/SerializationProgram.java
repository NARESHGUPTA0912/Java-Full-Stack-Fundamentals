package fileHandling.serializationDeserialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationProgram {
	public static void main(String[] args) {
		Employ e1 = new Employ(101, "John", 45000, "john123", "john@123");
		Employ e2 = new Employ(102, "Smith", 55000, "smith123", "smith@123");
		Employ e3 = new Employ(103, "David", 65000, "david123", "david@123");
		File f1=new File("f:\\employdata.ser");
		
		try(FileOutputStream fos=new FileOutputStream(f1);
			ObjectOutputStream oos=new ObjectOutputStream(fos);	
		){
			oos.writeObject(e1);
			oos.writeObject(e2);
			oos.writeObject(e3);
			
		}catch(Exception e) {
            System.out.println(e.getMessage());
        }
		System.out.println("Serialization Completed!");
	}

}
