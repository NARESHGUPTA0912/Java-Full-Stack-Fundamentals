package Q25_To_Q48;

public class FibonacciMemo {

    static int[] dp = new int[100];

    static int fib(int n) {

        if(n <= 1)
            return n;

        if(dp[n] != 0)
            return dp[n];

        dp[n] = fib(n-1) + fib(n-2);

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println(fib(n));
    }
}
