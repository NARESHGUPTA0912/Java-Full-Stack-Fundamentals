package Q49_To_Q68;

public class MajorityElement {

    // leetcode
    // public int majorityElement(int[] nums) {

    //     int candidate = 0;
    //     int count = 0;

    //     for(int num : nums) {

    //         if(count == 0)
    //             candidate = num;

    //         if(num == candidate)
    //             count++;
    //         else
    //             count--;
    //     }

    //     return candidate;
    // }
    public static void main(String[] args) {

        int[] arr = {3,3,4,2,4,4,2,4,4};

        int candidate = 0;
        int count = 0;

        for(int x : arr) {

            if(count == 0) {
                candidate = x;
            }

            if(x == candidate)
                count++;
            else
                count--;
        }

        count = 0;

        for(int x : arr) {
            if(x == candidate)
                count++;
        }

        if(count > arr.length/2)
            System.out.println(candidate);
        else
            System.out.println(-1);
    }
}