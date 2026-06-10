package javaIntermediate.WrapperClass;

public class Program10 {
	public static void main(String[] args) {
		Object o1=12;
		Object o2=34.6;
		
		Object o3=true;
		Object o4='@';
		Object o5="abcd";
		Object o6=new Car("TATA");
		
		System.out.println(o1);
		System.out.println((int)o1+100);
		System.out.println(o5);
		System.out.println((String)o5+100);
		System.out.println(((String)o5).length());
	}

}




