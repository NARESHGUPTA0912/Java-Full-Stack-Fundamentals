package javaOops.abstraction.interfacePrograms;

public interface Shape {

    /**  class is a blueprint for objects 
     * 
     * 
     * interface is a blueprint for classes 
     * interface contains only abstract, static, default, private methods and static constants
     */
    void rotate();
    default void test(){
        System.out.println("Default Method");
    }
}
