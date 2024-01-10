import java.util.Arrays;
public class Solution {


    static boolean[] findSubsetWithSumK(int [] arr, int n, int target) {
        boolean prev[] = new boolean[target + 1];
        prev[0] = true;

        if (arr[0] <= target)
            prev[arr[0]] = true;
        
        for (int index = 1; index < n; index++) {
            boolean curr[] = new boolean[target + 1];
            for (int k = 1; k <= target; k++) {
                boolean take = false;
                if (arr[index] <= k)
                    take = prev[k - arr[index]];
                boolean notTake = prev[k];
                curr[k] = take || notTake;
            }
            prev = curr;
        }

        return prev;
    }

    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        /**
            Total Weight
              /   \
             / min \
         subset1  subset2
        */

        

        int totalWeight = Arrays.stream(arr).sum();
        boolean[] dp = findSubsetWithSumK(arr, n, totalWeight);
        int min = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totalWeight; s1++) {
            if (dp[s1]) {
                int s2 = totalWeight - s1;
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }

        return min;

       
    }
}
