import java.util.* ;
import java.io.*; 
public class Solution {

	static int mod =(int)(Math.pow(10,9)+7);

	static int count(int arr[], int target) {
		int n = arr.length;
		int dp[][] = new int[n][target + 1];

		if (arr[0] == 0) dp[0][0] = 2;
		else dp[0][0] = 1;

		if (arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1;

		for (int index = 1; index < n; index++) {
			for (int k = 0; k <= target; k++) {
				int notTake = dp[index - 1][k];
				int take = 0;
				if (arr[index] <= k)
					take = dp[index - 1][k - arr[index]];
				
				dp[index][k] = (take + notTake) % (int)1e9 + 7;
			}
		}
		return dp[n - 1][target];

	}

	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int totalSum = Arrays.stream(arr).sum();

		/**
			* Assuming 2 subsets s1 and s2
			             arr
						 /\
						/  \
					   s1  s2

			* s1 >= s2
			* s1 - s2 = D -> (1)
			* S1 + S2 = Totalsum -> (2)

			By Substituting expr (2) and (1)
			(Ts - s2) - s2 = D
			S2 = (Ts - D) / 2
 		*/
		 if ((totalSum - d) < 0 || (totalSum - d) % 2 != 0) return 0; // if difference > total sum we cannot have such subsets
		 int s2 = (totalSum - d) / 2;
		 return count(arr, s2);

	}
}
