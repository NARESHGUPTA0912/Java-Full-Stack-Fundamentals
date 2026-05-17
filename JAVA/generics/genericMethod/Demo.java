package generics.genericMethod;

import java.util.List;

class Demo {

    <T> void show(T data) {
        System.out.println(data);
    }

    // Generic Methods with Bounds
    <T extends Number> void show(T value) {
        System.out.println(value);
    }

    // Unbounded Wildcard <?>
    void print(List<?> list) {

        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    // Upper Bounded Wildcard
    void display(List<? extends Number> list) {

        // It accepts: Integer, Double, Float
        for (Number n : list) {
            System.out.println(n);
        }
    }

    // Lower Bounded Wildcard
    void addData(List<? super Integer> list) {

        // It accepts: Integer, Number, Object
        list.add(10);
        list.add(20);
    }
}
