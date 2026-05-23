package Q25_To_Q48;
import java.util.Arrays;

public class KthLargest {
    public static void main(String[] args) {

        int[] arr = {3,2,1,5,6,4};
        int k = 2;

        Arrays.sort(arr);

        System.out.println(k + "th Largest = " + arr[arr.length-k]);
    }
}
