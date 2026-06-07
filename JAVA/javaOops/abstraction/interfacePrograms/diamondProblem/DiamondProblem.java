package javaOops.abstraction.interfacePrograms.diamondProblem;

public class DiamondProblem implements FirstInterface, SecondInterface{

    @Override
    public void test(){
        System.out.println("test from Int-1");
        FirstInterface.stats();
        SecondInterface.stats();
    }

    @Override
    public void defaultMethod() {
        
        System.out.println("Default 1 from class");
    }

    // public void test(){
    //     System.out.println("test from Int-2");
    // }
    
}
