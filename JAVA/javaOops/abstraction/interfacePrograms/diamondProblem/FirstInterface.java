package javaOops.abstraction.interfacePrograms.diamondProblem;

public interface FirstInterface {
    public void test();

    public default void defaultMethod(){
        System.out.println("Default Method from First Interface");
    }

    public static void stats(){
        System.out.println("Static method from First Interface");
        demo();
    }

    private static void demo(){
        System.out.println("Private method from First Interface");
    }
}
