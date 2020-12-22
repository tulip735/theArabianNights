import java.util.*;

public class SearchRotatedArray {

    /**
     You are given an integer array nums sorted in ascending order, and an integer target.
     Suppose that nums is rotated at some pivot unknown to you beforehand 
     (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     If target is found in the array return its index, otherwise, return -1.
     Example 1:
     Input: nums = [4,5,6,7,0,1,2], target = 0
     Input: nums = [5,6,7,-1,0,1,2,3,4], target = 1
     Output: 4
    */

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 左边有序, <=记住
            if (nums[left] <= nums[mid]) {
                if ( target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 右边有序
            else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // int[] nums = new int[] {4,5,6,8,0,1,2,3};
        int[] nums = new int[] {3,1};
        int res = search(nums,1);
        System.out.println(res);
        
    }




}
