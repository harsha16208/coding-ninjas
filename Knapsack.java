import java.util.* ;
import java.io.*; 

public class Solution{

    /**
        * Memoization
    **/
    static int f(int index, int bagWeight, int[] weight, int[] value, int[][] dp) {
        // base condition
        if (bagWeight == 0) return 0;
        if (index == 0) {
            if (weight[index] <= bagWeight) return value[index];
            return 0;
        }
        if (dp[index][bagWeight] != -1) return dp[index][bagWeight];

        //operate
        int notPick = 0 + f(index - 1, bagWeight, weight, value, dp);
        int pick = Integer.MIN_VALUE;
        if (weight[index] <= bagWeight)
            pick = value[index] + f(index - 1, bagWeight - weight[index], weight, value, dp);

        return dp[index][bagWeight] = Math.max(pick, notPick);
    }

    /**
        * Tabulation
    */
    static int count(int weight[], int val[], int n, int maxWeight) {
        // int dp[][] = new int[n][maxWeight + 1];
        int prev[] = new int[maxWeight + 1];

        // base case
        for (int i = weight[0]; i <= maxWeight; i++) prev[i] = val[0];

        //represent state
        for (int index = 1; index < n; index++) {
            int curr[] = new int[maxWeight + 1];
            for (int wt = 0; wt <= maxWeight; wt++) {
                // operate
                // int notPick = 0 + dp[index - 1][wt];
                int notPick = 0 + prev[wt];
                int pick = 0;
                if (wt >= weight[index])
                    // pick = val[index] + dp[index - 1][wt - weight[index]];
                    pick = val[index] + prev[wt - weight[index]];

                // Count max
                // dp[index][wt] = Math.max(pick, notPick);
                curr[wt] = Math.max(pick, notPick);
            }
            prev = curr;
        }

        // return dp[n - 1][maxWeight];
        return prev[maxWeight];
    }


    /**
        * Tabulation - 1D array
    */
    static int count2(int weight[], int val[], int n, int maxWeight) {
        int dp[] = new int[maxWeight + 1];

        // base case
        for (int i = weight[0]; i <= maxWeight; i++) dp[i] = val[0];

        //represent state
        for (int index = 1; index < n; index++) {
            for (int wt = maxWeight; wt >= 0; wt--) {
                // operate
                int notPick = 0 + dp[wt];
                int pick = 0;
                if (wt >= weight[index])
                    pick = val[index] + dp[wt - weight[index]];

                // Count max
                dp[wt] = Math.max(pick, notPick);
            }
        }

        // return dp[n - 1][maxWeight];
        return dp[maxWeight];
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        // int dp[][] = new int[n][maxWeight + 1];
        // for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // return f(n - 1, maxWeight, weight, value, dp);
        return count2(weight, value, n, maxWeight);
    }
}
