import java.util.* ;
import java.io.*; 
public class Solution {

	static long f(int[] arr, int start, int end) {
		long prev1 = arr[start];
		long prev2 = 0;

		for (int i = start + 1; i < end; i++) {
			long pick = arr[i] + prev2;
			long notPick = 0 + prev1;
			long curr = Math.max(pick, notPick);

			prev2 = prev1;
			prev1 = curr;
		}

		return prev1;
	}

	public static long houseRobber(int[] valueInHouse) {
		int n = valueInHouse.length;
		if (n == 1) return valueInHouse[n - 1];
		return Math.max(f(valueInHouse, 0, n - 1), f(valueInHouse, 1, n));
	}		
}
