import java.util.*;

class SortColors {
    /**
      Given an array with n objects colored red, white or blue, sort them in-place 
      so that objects of the same color are adjacent, with the colors in the order red, 
      white and blue.
      Here, we will use the integers 0, 1, and 2 to represent 
      the color red, white, and blue respectively.

      Example:
      Input: [2,0,2,1,1,0]
      Output: [0,0,1,1,2,2]

      Follow up:
      A rather straight forward solution is a two-pass algorithm using counting sort.
      First, iterate the array counting number of 0's, 1's, and 2's, 
      then overwrite array with total number of 0's, then 1's and followed by 2's.
      Could you come up with a one-pass algorithm using only constant space?
    */

    /**
      procedure three-way-partition(A : array of values, mid : value):
    i ← 0
    j ← 0
    k ← size of A
    while j < k:
        if A[j] < mid:
            swap A[i] and A[j]
            i ← i + 1
            j ← j + 1
        else if A[j] > mid:
            k ← k - 1
            swap A[j] and A[k]
        else:
            j ← j + 1
    */
    public static void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 2) {
                // if nums[j] == 2, nums[k] == 0, 还需交换一次，所以j位置不变
                swap(nums, j, k);
                k--;
            } else {
                j++;
            }
        }
    }
    public static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }


    public static void main(String[] args) {

        //int[] nums = new int[] {0,1,2,0,2,1};
        int[] nums = new int[] {2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
        
    }
}
