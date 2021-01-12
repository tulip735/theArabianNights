import java.util.*;


class MatrixChainMultiplication {

    /**
      matrix chain multiplication
    */
    public static int[][] maxtrixChainOrder(int[] nums) {
        int N = nums.length - 1;
        int[][] dp = new int[N + 1][N + 1];
        int[][] s = new int[N + 1][N + 1];

        for (int l = 2; l <= N; l++) {
            for (int i = 1; i <= N - l + 1; i++) {
                System.out.println(i);
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int x = dp[i][k] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j];
                    if (x < dp[i][j]) {
                        dp[i][j] = x;
                        s[i][j] = k;
                    }
                }
            }
        }
        return s;
    }

    private static void printOptimal(int[][] s, int left, int right) {
        if (left == right) {
            System.out.print("A");
            System.out.print(left);
        } else {
            System.out.print("(");
            printOptimal(s, left, s[left][right]);
            System.out.print("*");
            printOptimal(s, s[left][right] + 1, right);
            System.out.print(")");
        }
        
    } 


    public static void main(String[] args) {
        int[] nums = new int[] {30, 35, 15, 5, 10, 20, 25};
        printOptimal(maxtrixChainOrder(nums), 1, 6);
        
    }
    
}
