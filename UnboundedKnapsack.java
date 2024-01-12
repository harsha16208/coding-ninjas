import java.util.Arrays;
public class Solution {

    /**
        * Memoization
    */
    static int count(int index, int bagWeight, int[] profit, int[] weight, int[][] dp) { //representing states
        //Base-case
        if (index == 0) return (bagWeight / weight[0]) * profit[0];
        if (dp[index][bagWeight] != -1) return dp[index][bagWeight];
        //operations
        int notPick = 0 + count(index - 1, bagWeight, profit, weight, dp);
        int pick = Integer.MIN_VALUE;
        if (bagWeight >= weight[index])
            pick = profit[index] + count(index, bagWeight - weight[index], profit, weight, dp);

        return dp[index][bagWeight] = Math.max(pick, notPick);
    }

    /**
        * Tabulation
    */
    static int count2(int n, int w, int[] profit, int[] weight) {
        // int[][] dp = new int[n][w + 1];
        int[] prev = new int[w + 1];
        
        //Base condition
        for (int i = 0; i <= w; i++) 
            // dp[0][i] = (i / weight[0]) * profit[0];
            prev[i] = (i / weight[0]) * profit[0];

        // Represent states
        for (int index = 1; index < n; index++) {
            // int curr[] = new int[w + 1];
            for (int bagWeight = 0; bagWeight <= w; bagWeight++) {
                //operations
                // int notTake = 0 + dp[index - 1][bagWeight];
                int notTake = 0 + prev[bagWeight];
                int take = Integer.MIN_VALUE;
                if (bagWeight >= weight[index])
                    // take = profit[index] + dp[index][bagWeight - weight[index]];
                    take = profit[index] + prev[bagWeight - weight[index]];
                
                // dp[index][bagWeight] = Math.max(notTake, take);
                // curr[bagWeight] = Math.max(take, notTake);
                prev[bagWeight] = Math.max(take, notTake);
            }
            // prev = curr;
        }

        // return dp[n - 1][w];
        return prev[w];
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        // int[][] dp = new int[n][w + 1];
        // for (int i = 0; i < n; i++)
        //     Arrays.fill(dp[i], -1);
        // return count(n - 1, w, profit, weight, dp);
        return count2(n, w, profit, weight);
    }
}
