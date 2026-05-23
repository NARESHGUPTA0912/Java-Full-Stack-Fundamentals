package Q25_To_Q48;

public class PrimeElements {
    public static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,7,8,11};

        int count = 0;

        for(int el : arr){
            if(isPrime(el)){
                System.out.println(el+" ");
                count++;
            }
        }System.out.println("\nCount = " + count);
    }
}
