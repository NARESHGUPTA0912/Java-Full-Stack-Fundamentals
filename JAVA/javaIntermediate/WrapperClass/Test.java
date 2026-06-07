package javaIntermediate.WrapperClass;

public class Test {
    private static class Student {
        int id;
    }
    public static void main(String[] args) {
        Student student = new Student();
        student.id = 1;
        fun(student);
        System.out.println(student.id); // 1
        fun2(student);
        System.out.println(student.id); // 2
    }

    static void fun(Student s){
        Student student = new Student();
        student.id = 2;
        s = student;
    }

    static void fun2(Student s){
        s.id = 2;
    }
}
