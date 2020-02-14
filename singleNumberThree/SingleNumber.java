import java.util.*;

class SingleNumber {
    
    /**
      Given a non-empty array of integers, every element appears three times except for one, 
      which appears exactly once. Find that single one.
      Note:
      Your algorithm should have a linear runtime complexity. 
      Could you implement it without using extra memory?
      
      Example 1:
      Input: [2,2,3,2]
      Output: 3
    */

    public static int singleNumber(int[] nums) {
        int one = 0, two = 0, mask = 0;
        for (int i: nums) {
            two ^= one & i;
            one ^= i;
            mask = ~(one & two);
            one &= mask;
            two &= mask;
        }
        System.out.println(one);
        System.out.println(two);
        return one;
    }

    public static int singleNumberII(int[] nums) {
        // 利用数组存储每一位
        int result = 0;
        final int w = Integer.SIZE;
        System.out.println(w);
        int[] count = new int[w];
        for (int i:nums) {
            for (int j = 0; j < w; j++) {
                count[j] += (i >> j) & 1;
                count[j] = count[j] % 3;
            }
        }

        for (int j = 0; j < w; j++) {
            System.out.print(count[j]);
            System.out.print('\t');
            result += (count[j] << j);
        }
        System.out.print('\n');
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,3,2};
        int x = singleNumberII(nums);
        
    }
}
