package Q49_To_Q68;
import java.util.HashMap;

public class MaxFrequency {
    public static void main(String[] args) {

        int[] arr = {10,20,10,30,20,10};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x : arr) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int maxFreq = 0;
        int element = 0;

        for(Integer key : map.keySet()) {

            if(map.get(key) > maxFreq) {
                maxFreq = map.get(key);
                element = key;
            }
        }

        System.out.println(element + " -> " + maxFreq);
    }
}