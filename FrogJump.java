import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        // Write your code here..
        int prev2 = 0;
        int prev1 = 0;

        for (int i = 1; i < n; i++) {
            int oneStep = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int twoSteps = Integer.MAX_VALUE;
            if (i > 1)
            twoSteps = prev2 + Math.abs(heights[i] - heights[i - 2]);
            int curr = Math.min(oneStep, twoSteps);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

}

/**
  * Time complexity : O(n)
  * Space complexity : O(n)
*/
