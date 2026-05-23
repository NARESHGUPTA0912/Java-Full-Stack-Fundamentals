package Q25_To_Q48;

public class SecondSmallest {
    public static void main(String[] args) {

        int[] arr = {80,80,43,50,38,63,58,80};

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int x : arr) {

            if(x < first) {
                second = first;
                first = x;
            }
            else if(x < second && x != first) {
                second = x;
            }
        }

        System.out.println("Second Smallest = " + second);
    }
}
