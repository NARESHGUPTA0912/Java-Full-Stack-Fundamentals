package Medium;

import java.util.HashSet;
import java.util.Set;

public class SubArrayRemoval {
    public int subArrayRemoval(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return n - maxLen;
    }

    public static void main(String[] args) {
        SubArrayRemoval solution = new SubArrayRemoval();
        int[] nums = {1, 2, 1, 2, 3};
        int result = solution.subArrayRemoval(nums);  // expected: 2
        System.out.println("Minimum number of elements to remove: " + result);
    }
    
}
