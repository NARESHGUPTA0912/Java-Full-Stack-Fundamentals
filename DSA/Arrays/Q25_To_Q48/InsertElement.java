package Q25_To_Q48;

public class InsertElement {
    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50,60,70};
        int element = 35;
        int pos = 3;

        int[] res = new int[arr.length + 1];

        for(int i=0; i<pos; i++) {
            res[i] = arr[i];
        }

        res[pos] = element;

        for(int i=pos; i<arr.length; i++) {
            res[i+1] = arr[i];
        }

        for(int x : res) {
            System.out.print(x + " ");
        }
    }
}