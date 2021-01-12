import java.util.*;

class ReplaceBlank{
    /**
   */
    public static int[] minThree(int[] nums) {
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = Integer.MAX_VALUE;
        int minIndex = 0, secondIndex = 0, thirdIndex = 0;
        for (int i  = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                third = second;
                thirdIndex = secondIndex;

                second = min;
                secondIndex = minIndex;

                min = nums[i];
                minIndex = i;

            } else if (nums[i] < second) {
                third = second;
                thirdIndex = secondIndex;

                second = nums[i];
                secondIndex = i;
            } else if (nums[i] < third) {
                third = nums[i];
                thirdIndex = i;
            }
        }
        System.out.println(min);
        System.out.println(second);
        System.out.println(third);
        return nums;
    }

    public static void main(String[] args) {

        //int[] nums = new int[] {0,1,2,0,2,1};

        int[] nums = new int[] {5, 4, 3, 2, 1};
        String str = "cai chao dong";
        String res = str.replaceAll("\\s+","%20");
        System.out.println(res);
        System.out.println(str);
        minThree(nums);

        // sortColors(nums);
        // System.out.println(Arrays.toString(nums));
        
    }
}
