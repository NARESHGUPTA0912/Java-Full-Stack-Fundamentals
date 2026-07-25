package javaIntermediate.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        User e = new User("Naresh", "E001", 17,989898989);
        try {
            e.checkAge(e.getUserAge());
        } catch (UnderAgeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
