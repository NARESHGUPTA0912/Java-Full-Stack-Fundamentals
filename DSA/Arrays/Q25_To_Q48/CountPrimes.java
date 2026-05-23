package Q25_To_Q48;

public class CountPrimes {

    public static void main(String[] args) {

        int n = 50;
        boolean[] prime = new boolean[n + 1];

        for(int i=2; i<=n; i++)
            prime[i] = true;

        for(int i=2; i*i<=n; i++)
            if(prime[i])
                for(int j=i*i; j<=n; j+=i) 
                    prime[j] = false;

        int count = 0;
        for(int i=2; i<=n; i++)
            if(prime[i])
                count++;
        System.out.println("Count = " + count);
    }
}