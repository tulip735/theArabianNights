import java.util.*;

class MaxProfit {

    /**
       Say you have an array for which the ith element is the price of a given stock on day i.
       If you were only permitted to complete at most one transaction 
       (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    */
    /**
    def max_subarray(numbers):
    """Find a contiguous subarray with the largest sum."""
    best_sum = 0  # or: float('-inf')
    best_start = best_end = 0  # or: None
    current_sum = 0
    for current_end, x in enumerate(numbers):
        if current_sum <= 0:
            # Start a new sequence at the current element
            current_start = current_end
            current_sum = x
        else:
            # Extend the existing sequence with the current element
            current_sum += x

        if current_sum > best_sum:
            best_sum = current_sum
            best_start = current_start
            best_end = current_end + 1  # the +1 is to make 'best_end' exclusive

    return best_sum, best_start, best_end
    */

    public static int maxProfit(int[] prices) {
        //maximum sum subarray problem
        // 看作最大连续字串和问题
        int bestSum = 0;
        int curSum = 0;

        for (int i = 1; i < prices.length; i++) {
            curSum = Math.max(0, curSum + (prices[i] - prices[i - 1]));
            bestSum = Math.max(bestSum, curSum);
        }

        return bestSum;
    }

    public static void main(String[] args) {

        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);

        System.out.println(result);

    }
    
}
