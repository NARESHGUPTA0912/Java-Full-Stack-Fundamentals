package javaOops.abstraction.interfacePrograms.diamondProblem;

public interface SecondInterface {
    public void test();

    public default void defaultMethod(){
        System.out.println("Default Method from Second Interface");
    }

    public static void stats(){
        System.out.println("Static method from Second Interface");
        demo();
    }

    private static void demo(){
        System.out.println("Private method from Second Interface");
    }
}
