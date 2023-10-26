public class Solution {
    static boolean isKthBitSet(int n, int k) {
        // Write your code here.
        int set =  n & (1 << (k-1));
        return set == 0 ? false : true;
    }
}
