package Q69_To_Q82;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println();
    }

    // Leetcode 136: Single Number
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for(int i : nums)
            ans ^= i;
        return ans;
    }

    // Leetcode 137: Single Number II
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    // Leetcode 260: Single Number III
    public int[] singleNumber3(int[] nums) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        int diffBit = xor & (-xor);
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }

    // Leetcode 2150: Find All Lonely Numbers in the Array
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (freq.get(num) == 1 &&
                !freq.containsKey(num - 1) &&
                !freq.containsKey(num + 1)) {
                ans.add(num);
            }
        }
        return ans;
    }

    // Leetcode 1748: Sum of Unique Elements
    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums)
            freq[num]++;
        int sum = 0;
        for (int i = 1; i <= 100; i++)
            if (freq[i] == 1)
                sum += i;
        return sum;
    }

    // Leetcode 724: Find Pivot Index
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    // Leetcode 1991: Find the Middle Index in Array
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    // Leetcode 338: Counting Bits
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++)
            bits[i] = bits[i >> 1] + (i & 1);
        return bits;
    }

    // Leetcode 2595: Number of Even and Odd Bits
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        int pos = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                ans[pos % 2]++;
            pos++;
            n >>= 1;
        } return ans;
    }

    // Leetcode 1539: Kth Missing Positive Number
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int current = 1;
        int i = 0;

        while (missingCount < k) {
            if (i < arr.length && arr[i] == current) {
                i++; // number exists in array
            } else {
                missingCount++; // number is missing
                if (missingCount == k)
                    return current;
            }
            current++;
        }
        return -1;
    }

    // Leetcode 41: First Missing Positive
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // Step 1: Place numbers in correct index
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n 
                   && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
        // Step 2: Find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    // Leetcode 2729: Check if The Number is Fascinating
    public boolean isFascinating(int n) {
        String s = "" + n + (2*n) + (3*n);
        boolean []visited = new boolean[10];
        for(char c : s.toCharArray()){
            int digit = c-'0';
            if(digit==0 || visited[digit]){
                return false;
            }
            visited[digit] = true;
        }
        return true;
    }

    // Leetcode 121: Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            int profit = price - minPrice;
            if (profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }

    // Leetcode 11: Container With Most Water
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            // Width between lines
            int width = right - left;
            // Height is the smaller one
            int h = Math.min(height[left], height[right]);
            // Calculate area
            int area = width * h;
            // Update max area
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // Leetcode 42: Trapping Rain Water
    public int trap(int[] height) {
        int start=0, end=height.length-1;
        int leftMax=height[0],  rightMax=height[height.length-1];
        int water=0;
        while(start<end){
            if(height[start] < height[end]){
                if(height[start] > leftMax)
                    leftMax=height[start];
                else
                    water=water+leftMax-height[start];
                start++;
            } else {
                if(height[end] > rightMax)
                    rightMax=height[end];
                else
                    water=water+rightMax-height[end];
                end--;
            }
        }
        return water;
    }
}
