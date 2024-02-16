public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low = 1, high = m;

        while (low <= high) {
            int mid = (low + high) / 2;

            int val = (int)Math.pow(mid, n);
            if (val == m) return mid;
            if (val < m) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}
