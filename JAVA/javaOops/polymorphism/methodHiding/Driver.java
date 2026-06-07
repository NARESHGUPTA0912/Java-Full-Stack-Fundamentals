package javaOops.polymorphism.methodHiding;

public class Driver {
    public static void main(String[] args) {
        Vehicle.drive();
        Car.drive();
        Vehicle v = new Car();
        v.drive();
        Car c = new Car();
        c.drive();
        Car c2 = (Car)v;
        c2.drive();
    }
}
