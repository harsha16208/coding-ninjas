public class Solution {

    static int longestCommonSubsequence(int m, int n, String s1, String s2) {
        int prev[] = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int curr[] = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                //operations
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) curr[j] = 1 + prev[j - 1];
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[n];

    }

    public static int canYouMake(String s1, String s2) {
        // Write your code here.
        int m = s1.length();
        int n = s2.length();
        return m + n - 2 * longestCommonSubsequence(m, n, s1, s2);
    }
}
