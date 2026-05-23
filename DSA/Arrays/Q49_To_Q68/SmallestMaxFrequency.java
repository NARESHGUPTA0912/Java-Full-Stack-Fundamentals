package Q49_To_Q68;

import java.util.HashMap;

public class SmallestMaxFrequency {
    public static void main(String[] args) {

        int[] arr = {2,3,2,4,4,5};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x : arr) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int maxFreq = 0;
        int result = Integer.MAX_VALUE;

        for(Integer key : map.keySet()) {

            int freq = map.get(key);

            if(freq > maxFreq) {
                maxFreq = freq;
                result = key;
            }
            else if(freq == maxFreq && key < result) {
                result = key;
            }
        }

        System.out.println(result + " -> " + maxFreq);
    }
}