import java.util.*;

public class MergeIntervals {

    /**
      Given an array of intervals where intervals[i] = [starti, endi], 
      merge all overlapping intervals, and return an array of the 
      non-overlapping intervals that cover all the intervals in the input.

      Example 1:
      Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
      Output: [[1,6],[8,10],[15,18]]
      Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    */

    public static int[][] merge(int[][] nums) {

        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] x : nums) {
            if (merged.isEmpty() || merged.getLast()[1] < x[0]) {
                merged.add(x);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], x[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
        
    }

    public static void main(String[] args) {

        int[][] nums = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(nums);

        for (int[] x : result) {
            System.out.println(x[0]);
        }        
    }
}
