package Q49_To_Q68;

import java.util.HashSet;

public class AllUnique {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        HashSet<Integer> set = new HashSet<>();

        boolean unique = true;

        for(int x : arr) {

            if(set.contains(x)) {
                unique = false;
                break;
            }

            set.add(x);
        }

        System.out.println(unique);
    }
}