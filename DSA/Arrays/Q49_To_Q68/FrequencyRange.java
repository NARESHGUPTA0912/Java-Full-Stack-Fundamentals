package Q49_To_Q68;

public class FrequencyRange {
    public static void main(String[] args) {

        int[] arr = {10,20,10,30,20,10};

        int[] freq = new int[101];

        for(int x : arr) {
            freq[x]++;
        }

        for(int i=0; i<freq.length; i++) {

            if(freq[i] > 0) {
                System.out.println(i + " -> " + freq[i]);
            }
        }
    }
}