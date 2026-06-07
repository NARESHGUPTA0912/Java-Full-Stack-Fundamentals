package javaIntermediate.finalKeyword.finalMethod;

public class Car extends Vehicle{
    
    @Override
	public void start() {
		System.out.println("Start Car");
	}

	// cannot override because its final
    // @Override
	// public void stop(){
		
	// }
}
