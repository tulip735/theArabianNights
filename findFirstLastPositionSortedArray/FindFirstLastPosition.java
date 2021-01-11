import java.util.*;

public class FindFirstLastPosition {

    /**
     Given an array of integers nums sorted in ascending order, 
     find the starting and ending position of a given target value.
     If target is not found in the array, return [-1, -1].
     Follow up: Could you write an algorithm with O(log n) runtime complexity?
     Example 1:
     Input: nums = [5,7,7,8,8,10], target = 8
     Output: [3,4]
    */

    public static int[] searchRange(int[] nums, int target) {

        int[] result = new int[] {-1, -1};
        int l = 0, r = nums.length;
        // 寻找左侧边界, 注意搜索区间[l,r)
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            }
            else if (nums[mid] < target) {
                l = mid + 1; 
            }
        }
        if (l == nums.length || nums[l] != target)
            return result;
        result[0] = l;


        // 寻找右侧边界
        l = 0;
        r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1; 
            } else {
                r = mid;
            }
        }

        result[1] = l - 1;
        return result;
        
    }


    public static int[] searchRangeII(int[] nums, int target) {

        int start = helper(nums, target);
        // System.out.println(start);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        // 找到target + 1 insert的位置 - 1就是target的右边届
        return new int[] {start, helper(nums, target + 1) - 1};
        
    }

    public static int helper(int[] nums, int target) {


        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // if (l == nums.length || nums[l] != target)
        //     return -1;
        return l;

    }


    public static void main(String[] args) {


        int[] nums = new int[] {5, 7, 7, 8, 8, 10};
        int[] result = searchRangeII(nums, 8);
        for (int x : result) {
            System.out.println(x);
        }
        
    }


}
