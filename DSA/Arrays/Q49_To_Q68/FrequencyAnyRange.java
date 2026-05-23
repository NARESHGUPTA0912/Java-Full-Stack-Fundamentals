package Q49_To_Q68;

import java.util.HashMap;

public class FrequencyAnyRange {
    public static void main(String[] args) {

        int[] arr = {100,200,100,300,200,500};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}