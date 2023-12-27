import java.util.* ;
import java.io.*; 
import java.util.*;

public class Solution {

	
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n = nums.size(); 
		int prev1 = nums.get(0);
		int prev2 = 0;

		for (int i = 1; i < n; i++) {
			int pick = nums.get(i);
			if (i > 1) {
				pick += prev2;
			}
			int notPick = 0 + prev1;
			int curr = Math.max(pick, notPick);

			prev2 = prev1;
			prev1 = curr;
		}

		return prev1;
	}
}

/**
  
   * Tabulation + Space optimization using two pointers

   * Time complexity : O(n)
   * Space complexity  : O(1)

  Various possible techniques and their possible solutions

  * Recursion

  * Time complexity : O(2^n) -> Recursion call for every pick and non pick
  * Space complexity  : O(n)

  * Recursion + Memoization using DP array

  * Time complexity : O(n) -> Ignoring redundant calls by applying memoization, only n calls will be made for computing n nodes
  * Space complexity  : O(n)


  * Tabulation + DP array

  * Time complexity : O(n) -> for looping n elements
  * Space complexity  : O(n) -> for dp array
*/

