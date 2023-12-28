import java.util.* ;
import java.io.*; 
public class Solution {

	static int f(int m, int n, int[][] dp) {
		if (m == 0 && n == 0) return 1;
		if (m < 0 || n < 0) return 0;
		if (dp[m][n] != -1) return dp[m][n];

		int up = f(m - 1, n, dp);
		int left = f(m, n - 1, dp);

		return dp[m][n] = up + left;
	}

	public static int uniquePaths(int m, int n) {
		// Write your code here.
		// int[][] dp = new int[m][n];
		// for (int i = 0; i < m; i++) {
		// 	Arrays.fill(dp[i], -1);
		// }
		// // return f(m - 1, n - 1, dp);
		// for (int i = 0; i < m; i++) {
		// 	for (int j = 0; j < n; j++) {
		// 		if (i == 0 && j == 0) {
		// 			dp[i][j] = 1;
		// 			continue;
		// 		}
		// 		int up = 0, left = 0;
		// 		if (i > 0) up = dp[i - 1][j];
		// 		if (j > 0) left = dp[i][j - 1];
		// 		dp [i][j] = up + left;
		// 	}
		// }
		// return dp[m - 1][n - 1];

		int[] prev = new int[n];
		for (int i = 0; i < m; i++) {
			int temp[] = new int[n];
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					temp[j] = 1;
					continue;
				}
				int up = 0;
				int left = 0;
				if (i > 0) {
					up = prev[j];
				} 
				if (j > 0) {
					left = temp[j - 1];
				} 
				temp[j] = up + left;
			}
			prev = temp;
		}

		return prev[n - 1];
	}
}
