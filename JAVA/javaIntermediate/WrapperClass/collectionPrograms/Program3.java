package javaIntermediate.WrapperClass.collectionPrograms;
import java.util.*;
public class Program3 {
	public static void main(String[] args) {
		List l1=new ArrayList();
		l1.add(12);
		l1.add(34.6);
		l1.add("abc");
		l1.add(true);
		l1.add('@');
		System.out.println(l1);
		System.out.println(l1.get(0));
		System.out.println((int)l1.get(0)+100);
	}

}
