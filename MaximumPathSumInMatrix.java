import java.util.* ;
import java.io.*; 

public class Solution {

	static int f(int[][] grid, int i, int j, int[][] dp) {
		if (j < 0 || j >= grid[0].length) return -(int)10e7;
		if (i == 0) return grid[i][j];
		if (dp[i][j] != -1) return dp[i][j];

		int up = grid[i][j] + f(grid, i - 1, j, dp);
		int leftDiagonal = grid[i][j] + f(grid, i - 1, j - 1, dp);
		int rightDiagonal = grid[i][j] + f(grid, i - 1, j + 1, dp);

		return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
	}

	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];

		// for (int i = 0; i < m; i++) {
		// 	Arrays.fill(dp[i], -1);
		// }

		// int max = Integer.MIN_VALUE;

		// for (int i = 0; i < n; i++) {
		// 	max = Math.max(f(matrix, m - 1, i, dp), max);
		// }

		// return max;


	/**
		* Tabulation
	*/
		// for (int i = 0; i < n; i++) {
		// 	dp[0][i] = matrix[0][i];
		// }

		// for (int i = 1; i < m; i++) {
		// 	for (int j = 0; j < n; j++) {
		// 		int ld = -(int)10e7, rd = -(int)10e7;
		// 		int up = dp[i - 1][j];
		// 		if (j > 0) ld = dp[i - 1][j - 1];
		// 		if (j < n - 1) rd = dp[i - 1][j + 1];
		// 		dp[i][j] = matrix[i][j] + Math.max(up, Math.max(ld, rd));
		// 	}
		// }

		// int max = -(int)10e7;
		// for (int i = 0; i < n; i++) {
		// 	max = Math.max(max, dp[m - 1][i]);
		// }

		// return max;


		/**
		* Tabulation + Space optimization
		*/

		int prev[] = new int[n];
		for (int i = 0; i < n; i++) {
			prev[i] = matrix[0][i];
		}

		for (int i = 1; i < m; i++) {
			int curr[] = new int[n];
			for (int j = 0; j < n; j++) {
				int up = prev[j];
				int ld = -(int)10e7, rd = -(int)10e7;
				if (j > 0) ld = prev[j - 1];
				if (j < n - 1) rd = prev[j + 1];
				curr[j] = matrix[i][j] + Math.max(up, Math.max(ld, rd));
			}
			prev = curr;
		}
		int max = -(int)10e7;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, prev[i]);
		}

		return max;
	}

	
}
