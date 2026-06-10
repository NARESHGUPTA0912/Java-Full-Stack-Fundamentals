package javaIntermediate.generics.genericMethod;

public class Main {

    public static void main(String[] args) {

        Demo d = new Demo();

        d.show("Java");
        d.show(100);
        d.show(10.5);
        

        Calculator<Integer> c1 = new Calculator<>(10);
        Calculator<Double> c2 = new Calculator<>(5.5);
        System.out.println(c1.square());
        System.out.println(c2.square());

// Calculator<String> c3 = new Calculator<>("Java"); // Error
    }
}
