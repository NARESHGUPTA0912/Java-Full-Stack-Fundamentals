package Q49_To_Q68;

import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] arr = {10,20,10,30,20,40};

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(int x : arr) {
            set.add(x);
        }

        System.out.println(set);
    }
}