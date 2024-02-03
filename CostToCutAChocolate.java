import java.util.* ;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*; 
public class Solution {

    // consider entire array - Rule for Partition DP problems
    static int solve(int i, int j, List<Integer> cuts, int[][] dp) {
        // base case
        if (i > j) return 0;    
        if (dp[i][j] != -1) return dp[i][j];
        //operations
        int minCost = (int)1e9;
        for (int index = i; index <= j; index++) { // choosing a value from all cut values
            int cost = cuts.get(j + 1) - cuts.get(i - 1) + solve(i, index - 1, cuts, dp) + solve(index + 1, j, cuts, dp);
            minCost = Math.min(minCost, cost);
        }

        return dp[i][j] = minCost;
    }

    static int solveT(int c, List<Integer> cuts) {
        int dp[][] = new int[c + 2][c + 2];

        //Base case

        //Represent states
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;
                //operations
                int minCost = (int)1e9;
                for (int index = i; index <= j; index++) {
                    int cost = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][index - 1] + dp[index + 1][j];
                    minCost = Math.min(minCost, cost);
                }

                dp[i][j] = minCost;
            }
        }
        return dp[1][c];
    }

    public static int cost(int n, int c, int cutVal[]) {
        // Write your code here..
        int dp[][] = new int[c + 1][c + 1];
        for (int i = 0; i <= c; i++) Arrays.fill(dp[i], -1);
        Arrays.sort(cutVal);
        List<Integer> cuts = IntStream.of(cutVal).boxed().collect(Collectors.toList());
        cuts.add(0, 0);
        cuts.add(n);
        // return solve(1, c, cuts, dp);
        return solveT(c, cuts);
    }

}
