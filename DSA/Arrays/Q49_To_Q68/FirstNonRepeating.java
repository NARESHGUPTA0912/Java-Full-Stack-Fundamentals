package Q49_To_Q68;

import java.util.HashMap;

public class FirstNonRepeating {
    public static void main(String[] args) {

        int[] arr = {2,3,4,2,3,5,6};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x : arr) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int index = -1;

        for(int i=0; i<arr.length; i++) {

            if(map.get(arr[i]) == 1) {
                index = i;
                break;
            }
        }

        System.out.println(index);
    }
}