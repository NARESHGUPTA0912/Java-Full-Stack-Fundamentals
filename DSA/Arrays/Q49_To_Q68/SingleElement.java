package Q49_To_Q68;

public class SingleElement {
    public static void main(String[] args) {

        int[] arr = {2,3,5,4,5,3,4};

        int result = 0;

        for(int x : arr) {
            result ^= x;
        }

        System.out.println("Single Element = " + result);
    }
}