package Medium;

public class SmithNumber {
    public static boolean isSmith(int num){
        if(isPrime(num))
            return false; // prime numbers not considered smith numbers
        int sum1 = digitSum(num);
        int sum2 = 0;
        int temp = num;
        for(int i=2; i<=temp; i++){
            while(temp % i == 0){
                sum2 += digitSum(i);
                temp /= i;
            }
        }
        return sum1 == sum2;
    }

    public static boolean isPrime(int n){
        if(n <= 1)
            return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static int digitSum(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 37;
        if(isSmith(num)){
            System.out.println(num + " is a Smith number.");
        } else {
            System.out.println(num + " is not a Smith number.");
        }
    }
}
