package javaOops.abstraction.interfacePrograms.Basics;

// var. by default public static final
// non-static var. not allowed because constructor not allowed and static and non-static blocks also not allowed
// non-static methods by default public and abstract
// achieved abstarction provide simplicity
public interface Animal {
    void sleep();
    int MAX = 5;

    // used for utility functionality . 
    // we create interface for utility methods.
    // access only from interface ref not implement class ref 
    public static void info(){
        System.out.println("This is an Animal Interface");
    }

    // used for additional feature. if we want to add something in instance without breaking old impl.
    // can be override
    // if we add non-static abstract method in interface then all the imp. classes have error for override a method and provide imp.
    // so by preventing this, default method is used. it can access by imp. class obj ref.
    default void eat(){
        this.sleep(); // this method calls by implementation class object 
        System.out.println("Animal eating");
    }

    // we can write main method in interface and it is running even there is abstract method written
    // this main method is not go in implementation class
    public static void main(String[] args){
        System.out.println("This is a interface main method");
    }
}
