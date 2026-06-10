package javaIntermediate.generics;

import java.util.ArrayList;

class Program1 {

    public static void main(String[] args) {

        // without generics
        ArrayList list = new ArrayList();

        list.add("Java");
        list.add(100);

        String s = (String) list.get(0); // OK
        String n = (String) list.get(1); // Runtime Error

        // with generics
        ArrayList<String> list2 = new ArrayList<>();

        list2.add("Java");
// list.add(100); // Compile-time error

       // String s2 = list.get(0);
    }
}
