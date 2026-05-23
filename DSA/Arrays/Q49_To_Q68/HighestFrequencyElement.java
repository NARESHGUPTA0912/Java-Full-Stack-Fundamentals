package Q49_To_Q68;

import java.util.HashMap;

public class HighestFrequencyElement {
    public static void main(String[] args) {

        int[] arr = {1,2,2,3,3,3,4};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x : arr) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int ans = -1;
        int max = 0;

        for(Integer key : map.keySet()) {

            if(map.get(key) > max) {
                max = map.get(key);
                ans = key;
            }
        }

        System.out.println(ans);
    }
}