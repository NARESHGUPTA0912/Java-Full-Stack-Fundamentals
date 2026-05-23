package Q25_To_Q48;

public class SumPrime {

    static boolean isPrime(int n) {

        if(n < 2)
            return false;

        for(int i=2; i<=n/2; i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = {2,4,5,7,8,11};

        int sum = 0;

        for(int x : arr) {
            if(isPrime(x)) {
                sum += x;
            }
        }

        System.out.println("Sum = " + sum);
    }
}