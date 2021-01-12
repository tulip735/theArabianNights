import java.util.*;


public class findPeak {


    /**
     Given an integer array nums, find a peak element, and return its index. 
     If the array contains multiple peaks, return the index to any of the peaks.
     You may imagine that nums[-1] = nums[n] = -∞.
      Example 2:
      Input: nums = [1,2,1,3,5,6,4]
      Output: 5
      Explanation: Your function can return either index number 1 where the peak element is 2, 
      or index number 5 where the peak element is 6.
     */


    public static int find(int[] nums) {

        int left = 0, right = nums.length - 1;
        // 寻找最大值，最小值，边界值用<比较方便，最后比较剩余两个元素的值
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left] > nums[right] ? left : right;
        
    }


    public static void main(String[] args) {

        int[] nums = new int[] {1,2,1,3,5,6,4};
        int result = find(nums);
        System.out.println(result);
        
    }
}
