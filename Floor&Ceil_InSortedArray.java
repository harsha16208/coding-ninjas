import java.util.* ;
import java.io.*; 

public class Solution {

    static int floor(int[] a, int x, int n) {
      // element equals to x or longest element lesser than x
      int low = 0, high = n - 1;
      int ele = -1;
      while(low <= high) {
        int mid = (low + high) / 2;

        if (a[mid] <= x) {
          ele = a[mid];
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return ele;
    }

    static int ceil(int[] a, int x, int n) {
      // element equals to x or immediately greater than x
      int low = 0, high = n - 1;
      int ele = -1;

      while (low <= high) {
        int mid = (low + high) / 2;

        if (a[mid] >= x) {
          ele = a[mid];
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }

      return ele;
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      // Wriute your code here.
      return new int[]{floor(a, x, n), ceil(a, x, n)};
    }
    
}
