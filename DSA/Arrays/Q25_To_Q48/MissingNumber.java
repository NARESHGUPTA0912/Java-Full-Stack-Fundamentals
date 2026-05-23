package Q25_To_Q48;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        
        int arrSum = 0;
        for (int num : nums) {
            arrSum += num;
        }
        
        return expectedSum - arrSum;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,3,7,5,1,8,9,6};
        System.out.println("Missing Number = " + missingNumber(arr));
    }

}
