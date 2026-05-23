// 13, 11, 17, 21, 22, 24

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,7,4,4,5};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] a){
        int fe = a[0];
        for(int i=0; i<a.length-1; i++){
            a[i] = a[i+1];
        }
        a[a.length-1] = fe;
    }
}