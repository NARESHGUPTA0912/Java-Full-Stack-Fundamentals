package javaOops.abstraction.interfacePrograms.basics;

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d.MAX);
        d.sleep();
        System.out.println(Animal.MAX);
        Animal.info();
        d.eat();
        
        // main from interface can easily call with interface reference
        Animal.main(args);
    }
}
