package Q49_To_Q68;

import java.util.HashSet;

public class UniqueElements {
    public static void main(String[] args) {

        int[] arr = {10,12,18,6,15,17,11};

        HashSet<Integer> set = new HashSet<>();

        boolean flag = true;

        for(int x : arr) {

            if(set.contains(x)) {
                flag = false;
                break;
            }

            set.add(x);
        }

        System.out.println(flag);
    }
}
