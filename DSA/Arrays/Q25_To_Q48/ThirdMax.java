package Q25_To_Q48;

public class ThirdMax {
    public int thirdMax(int[] nums) {

        Long first = null;
        Long second = null;
        Long third = null;

        for(int num : nums) {

            long x = num;

            if((first != null && x == first) ||
               (second != null && x == second) ||
               (third != null && x == third)) {
                continue;
            }

            if(first == null || x > first) {
                third = second;
                second = first;
                first = x;
            }
            else if(second == null || x > second) {
                third = second;
                second = x;
            }
            else if(third == null || x > third) {
                third = x;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }
}
