package Q25_To_Q48;

import java.util.Arrays;

public class FibonacciArray {
    public static void main(String[] args) {
        int n = 16;
        int []fib = new int[n];
        fib[0] = 0;   fib[1] = 1;
        for(int i=2; i<n; i++)
            fib[i] = fib[i-1] + fib[i-2];
        System.out.println(Arrays.toString(fib));
    }
}
