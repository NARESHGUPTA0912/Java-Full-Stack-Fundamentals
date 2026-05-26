package ExceptionHandling;

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee("Naresh", "E001", 17);
        try {
            e.checkAge(e.getAge());
        } catch (UnderAgeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
