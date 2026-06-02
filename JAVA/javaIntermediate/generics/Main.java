package generics;

class Box<T> {

    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {

        Box<String> b1 = new Box<>();
        b1.set("Java");
        System.out.println(b1.get());

        Box<Integer> b2 = new Box<>();
        b2.set(100);
        System.out.println(b2.get());

         Pair<Integer, String> p = new Pair<>(101, "Naresh");
        p.display();
    }
}