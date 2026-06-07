package javaIntermediate.finalKeyword.finalClass;

public final class Vehicle extends Transport{
    String name;

    Vehicle(String name){
        this.name = name;
    }

    public void vehicleName(){
        System.out.println(name);
    }
}
