package javaBasics.oop.blocks;

public class VehicleDriver4 {
    public static void main(String[] args) {
        System.out.println("This is main method of VehicleDriver4");
        {
            System.out.println("This is a local block inside main method");
            System.out.println("x from local block is: " + Vehicle.x);
        }

    }
}
