import java.util.*;

import javax.naming.ldap.Rdn;
public class Solution {

	static int count(int index, int n, int price[], int[][] dp) {
		if (index == 0) return n * price[0];

		if (dp[index][n] != -1) return dp[index][n];
		//operations
		int notCut = 0 + count(index - 1, n, price, dp);
		int cut = Integer.MIN_VALUE;
		int rodLength = index + 1;

		if (rodLength <= n)
			cut = price[index] + count(index, n - rodLength, price, dp);
		
		return dp[index][n] = Math.max(cut, notCut);
	}

	/**
		* Tabulation
	*/
	static int count2(int price[], int n) {
		int dp[][] = new int[n][n + 1];

		//base case
		for (int i = 0; i <= n; i++) dp[0][i] = i * price[0];

		// represent states
		for (int index = 1; index < n; index++) {
			for (int len = 0; len <= n; len++) {
				//operate
				int notCut = 0 + dp[index - 1][len];
				int cut = Integer.MIN_VALUE;
				int rodLength = index + 1;
				if (rodLength <= len)
					cut = price[index] + dp[index][len - rodLength];
				dp[index][len] = Math.max(notCut, cut);
			}
		}
		return dp[n - 1][n];

	}

	public static int cutRod(int price[], int n) {
		// Write your code here.
		// int dp[][] = new int[n][n + 1];
		// for (int i = 0; i < n; i++)
		// 	Arrays.fill(dp[i], -1);
		// return count(n - 1, n, price, dp);
		return count2(price, n);
	}
}
