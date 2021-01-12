import java.util.*;



public class InsertInterval {

    /**
     Given a set of non-overlapping intervals, 
     insert a new interval into the intervals (merge if necessary).
     You may assume that the intervals were initially sorted according to their start times.

     Example 1:
     Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     Output: [[1,5],[6,9]]

     Example 2:
     Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     Output: [[1,2],[3,10],[12,16]]
     Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     */

    public static int[][] insert(int[][] intervals, int[] newInterval) {


        List<int[]> result = new LinkedList<>();
        int i = 0;
        int start = newInterval[0], end = newInterval[1];

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // 注意小于等于,可以继续拼接
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }


        result.add(new int[]{start, end});
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {


        // int[][] nums = new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        // int[] newInterval = new int[] {4, 8};

        // int[][] nums = new int[][] {{1,5}};
        // int[] newInterval = new int[] {1, 7};
        int[][] nums = new int[][] {{1,5}};
        int[] newInterval = new int[] {0, 7};
        int[][] result = insert(nums, newInterval);

        for (int[] x : result) {
            System.out.print(x[0]);
            System.out.print(x[1]);
        }
        
    }
}
