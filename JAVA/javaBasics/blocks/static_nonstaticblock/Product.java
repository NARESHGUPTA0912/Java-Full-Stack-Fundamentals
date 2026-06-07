package javaBasics.blocks.static_nonstaticblock;

class Product{
	
	static int count=0;
	
	{
		count++;
		System.out.println("Product Object "+count+" is created!");
	}
}



