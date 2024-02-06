import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        /**
        * Brute force : TC : O(nlogn) + O(mlogm) + O(n + m)
        * SC : O(n + m) + O(n + m)
        */
        // Set<Integer> set = new TreeSet<>();
        // for (int num : a) set.add(num);
        // for (int num : b) set.add(num);
        // List<Integer> list = new ArrayList<>(set);
        // return list;

        //Optimal approach
        /**
        * SC: O(n + m); TC : O(n + m)
        */
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        int n = a.length;
        int m = b.length;
        
        while (i < n && j < m) {
            int ele = 0;
            if (a[i] < b[j]) {
                ele = a[i];
                i++;
            } else {
                ele = b[j];
                j++;
            }
            if (res.size() > 0 && res.get(res.size() - 1) == ele) continue;
            res.add(ele);
        }

         while (i < n) {
            if (res.get(res.size() - 1) == a[i]) {
                i++;
                continue;
            }
            res.add(a[i]);
            i++;
        }

        while (j < m) {
            if (res.get(res.size() - 1) == b[j]) {
                j++;
                continue;
            }
            res.add(b[j]);
            j++;
        }

        return res;

    }
}
