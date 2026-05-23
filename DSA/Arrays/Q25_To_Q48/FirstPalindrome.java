package Q25_To_Q48;

public class FirstPalindrome {

    static boolean isPalindrome(int n) {

        int temp = n, rev = 0;

        while(n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return temp == rev;
    }

    public static void main(String[] args) {

        int n = 50;
        int[] arr = new int[n];
        int num = 1, index = 0;

        while(index < n) {
            if(isPalindrome(num)) 
                arr[index++] = num;
            num++;
        }

        for(int x : arr)
            System.out.print(x + " ");
    }
}
