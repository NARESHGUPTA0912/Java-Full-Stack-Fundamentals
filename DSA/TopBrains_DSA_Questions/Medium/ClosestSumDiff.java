package Medium;
import java.util.Arrays;

public class ClosestSumDiff {
        public static int closestSumDifference(int[] numbers, int target) {
        Arrays.sort(numbers);
        int left=0;
        int right=numbers.length-1;
        int minDiff=Integer.MAX_VALUE;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            int diff = Math.abs(target - sum);
            minDiff = Math.min(minDiff, diff);
            if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] numbers = {11, 23, 15, 73, 19};
        int target = 10;
        int result = closestSumDifference(numbers, target);
        System.out.println("The closest sum difference is: " + result);
    }
}

