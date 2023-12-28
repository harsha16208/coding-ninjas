/**
Approach -1 : Recursion + Memoization

* Space complexity : O(n) * O(n * 4) => Recursion stack space + DP array for memoization
* Time complexity : O(n * 4) * 3 => n * 4 states for every day and checking 3 tasks on each day

/*import java.util.Arrays;

public class Solution {

  static int f(int points[][], int day, int lastDayTask, int dp[][]) {
        if (dp[day][lastDayTask] != -1) return dp[day][lastDayTask];
        int maxPoints = Integer.MIN_VALUE;
        if (day == 0) {
            for (int task = 0; task <= 2; task++) {
                if (task != lastDayTask) {
                    maxPoints = Math.max(maxPoints, points[day][task]);
                }
            }
            return dp[day][lastDayTask] = maxPoints;
        }
        
        maxPoints = Integer.MIN_VALUE;
        for (int task = 0; task <= 2; task++) {
            if (task != lastDayTask) {
                int currPoints = points[day][task] + f(points, day - 1, task, dp);
                maxPoints = Math.max(currPoints, maxPoints);
            }
        } 
        return dp[day][lastDayTask] = maxPoints;
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int dp[][] = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(points, n - 1, 3, dp);
    }

}*/


/** Approach-2 Tabulation
import java.util.Arrays;

public class Solution {

    public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        int dp[][] = new int[n][4]; // dp array for storing points dp[day][lastDay]

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        // dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));z

        for (int day = 1; day < n; day ++) {
            for (int last = 0; last < 4; last++) {
                int maxPoints = Integer.MIN_VALUE;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int currPoints = dp[day - 1][task] + points[day][task];
                        maxPoints = Math.max(currPoints, maxPoints);
                    }
                }
                dp[day][last] = maxPoints;
            }
        }

        return dp[n - 1][3];
        
    }

}
  */

/*
  * Approach-3 Tabulation + Space optimization
*/
public class Solution {

    public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        int prev[] = new int[4]; // dp array for storing points dp[day][lastDay]

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day ++) {
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        temp[last] = Math.max(prev[task] + points[day][task], temp[last]);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
        
    }

}

  

