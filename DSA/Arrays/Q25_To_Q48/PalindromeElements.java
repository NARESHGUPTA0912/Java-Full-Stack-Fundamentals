package Q25_To_Q48;

public class PalindromeElements {

    static boolean isPalindrome(int n) {

        int temp = n;
        int rev = 0;

        while(n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return temp == rev;
    }

    public static void main(String[] args) {

        int[] arr = {121,123,454,678,989};

        int count = 0;

        for(int x : arr) {
            if(isPalindrome(x)) {
                System.out.print(x + " ");
                count++;
            }
        }

        System.out.println("\nCount = " + count);
    }
}
