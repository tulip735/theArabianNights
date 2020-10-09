import java.util.*;


public class MaxProduct {
    /**
     Given an integer array nums, find the contiguous subarray within an array 
     (containing at least one number) which has the largest product.

     Example 1:
     Input: [2,3,-2,4]
     Output: 6
     Explanation: [2,3] has the largest product 6.
     Example 2:
     
     Input: [-2,0,-1]
     Output: 0
     Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
    */

    public static int maxProduct(int[] nums) {

        // [-2, 3, -4]
        int result = Integer.MIN_VALUE;
        int pMax = 1, pMin = 1;

        //这道题妙就妙在它不仅仅依赖了一个状态（前一个数所能获得的最大乘积），
        //而是两个状态（最大和最小乘积）。比较简单的dp问题可能就只是会建立一个dp[]，然后把最大值放到其中
        for (int i = 0; i < nums.length; i++) {

            int tmp = pMax;
            pMax = Math.max(Math.max(pMax * nums[i], nums[i]), pMin * nums[i]);
            pMin = Math.min(Math.min(tmp * nums[i], nums[i]), pMin * nums[i]);
            System.out.println(pMax);
            System.out.println(pMin);

            result = Math.max(result, pMax);
            
        }
        return result;
    }

    public static void main(String[] args) {


        //int[] nums = new int[] {2, 3, -2, 4};
        int[] nums = new int[] {-4, -3, -2};

        int res = maxProduct(nums);
        System.out.println(res);



        
    }
}








