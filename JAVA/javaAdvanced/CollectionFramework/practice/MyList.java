package javaAdvanced.CollectionFramework.practice;

import java.util.ArrayList;
import java.util.Collections;

class MyList{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<String> list2 = new ArrayList<>();

        // add elements
        list.add(0);        list.add(2);        list.add(5);
        System.out.println(list);

        // get elements
        System.out.println(list.get(2));

        // add element in between
        list.add(1,1);
        System.out.println(list);

        // set element
        list.set(0, 5);
        System.out.println(list);

        //delete element
        list.remove(3);
        System.out.println(list);

        // size
        System.out.println(list.size());

        // loops
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) +"  ");
        }System.out.println();

        // sorting
        Collections.sort(list);
        System.out.println(list);

        // capacity
        list.ensureCapacity(20);

        // synchronized
        Collections.synchronizedList(list);
        System.out.println(list.stream().findAny());
    }
}