package fileHandling.serializationDeserialization;

public class Driver {
	public static void main(String[] args) {
		Employ e1=new Employ(101,"John",45000,"john123","john@123");
		Employ e2=new Employ(102,"Smith",55000,"smith123","smith@123");
		Employ e3=new Employ(103,"David",65000,"david123","david@123");
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
	}

}
