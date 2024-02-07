import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int longestSubarrayWithSumK(int []nums, long k) {
        // Write your code here
        // Prefix sum
        // Map<Long, Integer> map = new HashMap<>();
        // long sum = 0;
        // int maxLen = 0;
        // for (int i = 0; i < a.length; i++) {
        //     sum += a[i];
        //     if (sum == k) {
        //         maxLen = Math.max(maxLen, i + 1);
        //     }
        //     if (map.containsKey(sum - k)) {
        //         int lenDiff = i - map.get(sum - k);
        //         maxLen = Math.max(lenDiff, maxLen);
        //     }
        //     if (!map.containsKey(sum))
        //         map.put(sum, i);
        // }
        // return maxLen;

        //Two pointer
        int n = nums.length;
		int i = 0, j = 0;
		long sum = 0;
        int maxLen = 0;
		while (j < n) {
			sum += nums[j];

			while (i <= j && sum > k) {
				sum -= nums[i];
				i++;
			}

            if (sum < k) j++;

			if (sum == k) {
				maxLen = Math.max(maxLen, j - i + 1);
				j++;
			}
		}
		return maxLen;
    }
}
