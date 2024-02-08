import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        //Brute force : Linear search :TC O(N ^ 2); SC: O(n)
        //optimal

        List<Integer> res = new ArrayList<>();
        int n = a.length;
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > max) {
                res.add(a[i]);
                max = a[i];
            }
        }

        return res;
    }
}
