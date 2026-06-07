package javaOops.abstraction.interfacePrograms.diamondProblem2;

public interface Camera {
    
    void openCamera();
    void clickPhoto();
    void closeCamera();

    static void securedCamera(){
        System.out.println("Camera under Security");
    }

}
