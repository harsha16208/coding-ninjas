import java.util.* ;
import java.io.*; 
public class Solution {

    static boolean f(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) return target == arr[index];
        if (dp[index][target] != -1) return dp[index][target] == 1 ? true : false;

        boolean take = false;
        if (target >= arr[index])
            take = f(index - 1, target - arr[index], arr, dp);
        boolean notTake = f(index - 1, target, arr, dp);
        
        dp[index][target] = (take || notTake) ? 1 : 0;
        
        return dp[index][target] == 1 ? true : false;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[][] dp = new boolean[n][k + 1];
        // int[][] dp = new int[n + 1][k + 1];
        // for (int i = 0; i < n; i++)
        //     Arrays.fill(dp[i], -1);
        // return f(n - 1, k, arr, dp);

        // for (int i = 0; i < n; i++) {
        //     dp[i][0] = true;
        // }
        // if (arr[0] <= k)
        //     dp[0][arr[0]] = true;

        // for (int index = 1; index < n; index++) {
        //     for (int target = 1; target <= k; target++) {
        //         boolean take = false;
        //         if (target >= arr[index])
        //             take = dp[index - 1][target - arr[index]];
        //         boolean notTake = dp[index - 1][target];
        //         dp[index][target] = take || notTake;
        //     }
        // }

        // return dp[n - 1][k];

        /**
        * Tabulation + space optimization
        */
        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        
        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int index = 1; index < n; index++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1;  target <= k; target++) {
                boolean take = false;
                if (arr[index] <= target)
                    take = prev[target - arr[index]];
                boolean notTake = prev[target];
                curr[target] = take || notTake;
            }
            prev = curr;
        }

        return prev[k];
    }
}
