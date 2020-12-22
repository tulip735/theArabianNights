import java.util.*;

public class SearchRotatedArrayDuplicated {

    /**
      You are given a target value to search. 
      If found in the array return true, otherwise return false.
      Example 1:
      Input: nums = [2,5,6,0,0,1,2], target = 0
      Output: true

      Example 2:
      Input: nums = [2,5,6,0,0,1,2], target = 3
      Output: false
    */

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 左边有序, 
            if (nums[left] < nums[mid]) {
                if ( target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 右边有序
            else if (nums[left] > nums[mid]){
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // 如果l == mid, 就移动一个距离
            else {
                left = left + 1;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1,3,1,1,1,1};
        boolean res = search(nums,3)
    }


}
