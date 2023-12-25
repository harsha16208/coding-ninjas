import java.util.*;
public class Solution {

      static int mergeSort(int l, int r, int[] a) {
        if (l >= r) {
            return 0;
        }
        int count = 0;
        int mid = (l + r) / 2;
        count += mergeSort(l, mid, a);
        count += mergeSort(mid + 1, r, a);
        count += merge(l, mid, r, a);
        return count;
    }

    static int merge(int l, int mid, int r, int[] a) {
        int count = 0;
        List<Integer> temp = new ArrayList<>();
        int c1 = l;
        int c2 = mid + 1;
        int c3 = l;
        while (c1 <= mid && c2 <= r) {
            if (a[c1] <= a[c2]) {
                temp.add(a[c1]);
                c1++;
            } else {
                count += mid - c1 + 1;
                temp.add(a[c2]);
                c2++;
            }
        }

        while (c1 <= mid) {
            temp.add(a[c1]);
            c1++;
        }

        while (c2 <= r) {
            temp.add(a[c2]);
            c2++;
        }

        for (int i = l; i <= r; i++) {
            a[i] = temp.get(i - l);
        }

        return count;
        
    }



    public static int numberOfInversions(int []a, int n) {
        // Write your code here.
        return mergeSort(0, n - 1, a);
    }
}
