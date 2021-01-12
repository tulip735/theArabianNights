import java.util.*;



public class SingleElement {

    /**
     You are given a sorted array consisting of only integers where every element appears exactly twice, 
     except for one element which appears exactly once. Find this single element that appears only once.
     Follow up: Your solution should run in O(log n) time and O(1) space.
     
     Example 1:
     Input: nums = [1,1,2,3,3,4,4,8,8]
     Output: 2
    */

    /**
    Some explanation for what is going on in this solution
      [1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6] // target in the beginning
      [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6] // target in the middle
      [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6] // target in the end
      
      All 3 variants can be considered as a 'broken' sequence of pairs:
      [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6] // clear, without target
      Observations:
      
      the number of elems is always odd
      the pair indexes go from left=0 till right=nums.size()/2. Round down on divide helps: e.g. 11/2=5 valid pairs
      we can consider elems as pairs: nums[i*2]==nums[i*2+1] till we reach the 'broken' pair
      let's use binary search to divide the sequence to 'clear' and 'already broken'
      Let's check again:
      [|1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6] // target in the beginning
      0 pairs in clear part
      [1, 1, 2, 2, 3, 3, | 4, 5, 5, 6, 6] // target in the middle
      3 pairs in clear part
      [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, | 6] // target in the end
      5 pairs in clear part

      So our answer is the first element right after the 'clear' part.
      With a binary search, we narrow down the boundaries between 'clear' (on the left) and 'broken' (on the right) till there is a gap between them (left<right). As soon as left==right, we found the boundary and thus found the target!
      */
    public static int singleNonDuplicate(int[] nums) {


        int l, r, mid;
        for (l = 0, r = nums.length / 2; l < r;) {
            mid = (l + r) / 2;
            if (nums[mid * 2] == nums[mid*2 + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l*2];
    }



    public static void main(String[] args) {

        // int[] nums = new int[] {1,1,2,3,3,4,4,8,8};
        int[] nums = new int[] {0,1,1,3,3,4,4,8,8};
        int res = singleNonDuplicate(nums);
        System.out.println(res);

        
    }
}
