

import java.util.*;

public class TriangleSum {


    /**
     * 14. Given a triangle, find the minimum path sum from top to bottom.
     * Each step you may move to adjacent numbers on the row below.
     * For example, given the following triangle
     * [
     *    [2],
     *   [3,4],
     *  [6,5,7],
     *  [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        // two dimentions array to save state
        // int[][] dp = new int[n][n];

        // for (int i = 0; i < triangle.get(n-1).size(); i++) {
        //     dp[n-1][i] = triangle.get(n-1).get(i);
        // }
        // // dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + trai[i][j];
        // for (int i = n - 2; i >=0; i--) {
        //     for (int j = 0; j <= i; j++) {
        //         dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
        //     }
        // }
        // return dp[0][0];

        //滚动数组
      /**
        minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];
        Or even better, since the row minpath[k+1] would be useless after minpath[k] is computed, 
        we can simply set minpath as a 1D array, and iteratively update itself:

        For the kth level:
        minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i]; 
      */

        int[] dp = new int[n];
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
      
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j + 1], dp[j]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>(Arrays.asList(2)));
        t.add(new ArrayList<>(Arrays.asList(3,4)));
        t.add(new ArrayList<>(Arrays.asList(6,5,7)));
        t.add(new ArrayList<>(Arrays.asList(4,1,8,3)));

        int result = minimumTotal(t);
        System.out.println(result);


        
    }
}
