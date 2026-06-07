package javaOops.abstraction.interfacePrograms.diamondProblem2;

public interface Phone {
    default void emergencyCall(){
        System.out.println("Police / Hospital / Ambulance");
    }
    void makeCall();
    void doTalk();
    void dispatchCall();
}
