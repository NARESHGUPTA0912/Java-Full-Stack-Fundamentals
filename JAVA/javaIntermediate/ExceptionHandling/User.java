package ExceptionHandling;

import java.util.Scanner;

public class User {
    private String username;
    private String uid;
    private int userage;
    private long userMobile;

    public User(String username, String uid, int userage, long userMobile) {
        this.username = username;
        this.uid = uid;
        this.userage = userage;
        this.userMobile = userMobile;
    }

    public String getUsername() {
        return username;
    }

    public String getUid() {
        return uid;
    }

    public int getUserAge() {
        return userage;
    }

    public void checkAge(int age) throws UnderAgeException {
        if(age < 18) {
            throw new UnderAgeException("Employee is underage");
        } else {
            System.out.println("Employee is of legal age");
        }
    }

    public String userRegistration() throws UnderAgeException() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Name: ");
        String name = sc.nextLine();
        int age = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        try {
            checkAge(age);
        } catch (UnderAgeException e) {
            System.out.println(e.getMessage());
            return "User Registration Failed";
        }
        System.out.println("Enter User ID: ");
        String id = sc.nextLine();
        System.out.println("Enter User Mobile: ");
        long mobile = sc.nextLong();
            return "User Registered Successfully";
    }

}
