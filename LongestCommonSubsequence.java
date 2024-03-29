public class Solution {
    public static int lcs(String str1, String str2){
        // Write your code here.
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        //represent states
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //operate
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans;
    }
}
