package javaIntermediate.WrapperClass.collectionPrograms;
import java.util.*;
public class Program1 {
	public static void main(String[] args) {
		Integer x=12;
		System.out.println(x+100);
		Object o=12;
		
		System.out.println((Integer)o+100);
		
		ArrayList a1=new ArrayList();
		a1.add(12);	a1.add(34.6);	a1.add("abc");
		a1.add(true);	a1.add(44.6); a1.add(44);
		System.out.println(a1);
		int sum=0;
		for(Object p:a1) {
			if(p instanceof Integer)
				sum=sum+(Integer)p;
		}
		System.out.println("Sum is: "+sum);	
	}
}






