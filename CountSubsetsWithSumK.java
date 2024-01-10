import java.util.*;
import java.io.*;

public class Solution {

    static int mod =(int)(Math.pow(10,9)+7);

    /**
        * Memoization
    */
    static int count(int index, int target, int arr[], int dp[][]) {
        // Base condition
        if (index == 0) {
            if (target == 0 && arr[index] == 0) return 2; //If index has element 0 it has 2 ways take/not take
            if (target == 0) return 1;
            if (arr[index] == target) return 1;
            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        //operations on index
        int notTake = count(index - 1, target, arr, dp);
        int take = 0;
        if (arr[index] <= target) {
            take = count(index - 1, target - arr[index], arr, dp);
        }

        // sum all ways
        return dp[index][target] = (take + notTake) % (int)(1e9 + 7);
    }

    /**
        * Tabulation
    */

    static int count(int num[], int target) {
        int n = num.length;
        int dp[][] = new int[n][target + 1];

        // Base cases
        if (num[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (num[0] != 0 && num[0] <= target) dp[0][num[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int k = 0; k <= target; k++) {
                int notTake = dp[ind - 1][k];
                int take = 0;
                if (num[ind] <= k)
                    take = dp[ind - 1][k - num[ind]];
                dp[ind][k] = (take + notTake) % (int)(1e9 + 7);
            }
        }
        return dp[n - 1][target];
    }

    public static int findWays(int num[], int tar) {
        // Write your code here.
        // int n = num.length;
        // int dp[][] = new int[n][tar + 1];
        // for (int i = 0; i < n; i++)
        //     Arrays.fill(dp[i], -1);

        // return count(n - 1, tar, num, dp);
        return count(num, tar);
    }
}
