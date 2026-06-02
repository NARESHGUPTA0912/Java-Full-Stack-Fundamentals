package Medium;

public class HasPairWithSum {
    public static boolean hasPairWithSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return true;
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static boolean hasPairWithSumBruteForce(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 9;
        boolean result = hasPairWithSum(numbers, target);
        System.out.println("Does the array have a pair with the given sum? " + result);
    }
}
