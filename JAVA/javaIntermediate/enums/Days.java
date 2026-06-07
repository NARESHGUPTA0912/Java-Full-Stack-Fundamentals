package javaIntermediate.enums;

public enum Days {

    SUNDAY("sunday", "ravivar"), 
    MONDAY("monday", "somvar"), 
    TUESDAY("tuesday", "mangalvar"), 
    WEDNESDAY("wednesday", "budhavar"), 
    THURSDAY("thursday", "guruvar"), 
    FRIDAY("friday", "shukravar"), 
    SATURDAY("saturday", "shanivar");

    // write after enum Constants
    private final String lower;
    private String hindi;

    public String display() {
        return "Today is " + this.name();
    }

    public String getHindi(){
        return hindi;
    }

    private Days(String lower) {
        System.out.println("our constructor called");
        this.lower = lower;
    }

    private Days(String lower, String hindi){
        this(lower);
        this.hindi = hindi;
    }

    public String getLower() {
        return lower;
    }

    public static void main(String[] args){
        System.out.println("Hello WOrld");
    }
}
