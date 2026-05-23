package Q25_To_Q48;

import java.util.Arrays;

public class FirstNPrime {

    static boolean isPrime(int n) {
        if(n < 2)
            return false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int n = 10;
        int []primes = new int[n];
        int num = 2, index = 0;
        while(index<n){
            if(isPrime(num)){
                primes[index++] = num;
            }num++;
        }System.out.println(Arrays.toString(primes));
    }
}
