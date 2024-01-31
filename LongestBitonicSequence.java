import java.util.Arrays;

public class Solution {
    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // Find longest increasing sequence and decreasing sequence and remove 1 (common element)
        for (int i = 1; i < n; i++) {
            for (int prev = i - 1; prev >= 0; prev--) {
                if (arr[prev] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[prev] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = n - 1; prev >= i; prev--) {
                if (arr[prev] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[prev] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp1[i] + dp2[i] - 1, max);
        }

        return max;
    }
}
