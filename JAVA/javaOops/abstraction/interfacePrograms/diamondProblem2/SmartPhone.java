package javaOops.abstraction.interfacePrograms.diamondProblem2;

public class SmartPhone implements Camera, Phone, Torch {

    @Override
    public void onTorch() {
        System.out.println("Torch is ON");
    }

    @Override
    public void offTorch() {
        System.out.println("Torch is OFF");
    }

    @Override
    public void makeCall() {
        System.out.println("Make Call");
    }

    @Override
    public void doTalk() {
        System.out.println("Talking");
    }

    @Override
    public void dispatchCall() {
        System.out.println("Call Dispatch");
    }

    @Override
    public void openCamera() {
        System.out.println("Open Camera");
    }

    @Override
    public void clickPhoto() {
        System.out.println("Click the picture");
    }

    @Override
    public void closeCamera() {
        System.out.println("Close Camera");
    }

}
