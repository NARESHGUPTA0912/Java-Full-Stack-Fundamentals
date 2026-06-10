package fileHandling.serializationDeserialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationProgram {
	public static void main(String[] args) {
		

		try (FileInputStream fis = new FileInputStream("f:\\employdata.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			Employ e1=(Employ)ois.readObject();
			Employ e2 = (Employ) ois.readObject();
			Employ e3 = (Employ) ois.readObject();
			//Employ e4 = (Employ) ois.readObject();
			System.out.println(e1);
			System.out.println(e2);
			System.out.println(e3);
			//System.out.println(e4);

		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		}

		System.out.println("Deserialized Employ Data is completed:");
	}

}
