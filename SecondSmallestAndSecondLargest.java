public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        int[] res = new int[2];

        int max = Integer.MIN_VALUE;
        int prevMax = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int prevMin = Integer.MAX_VALUE;

        /**
        * Finding Second largest element.
        */

        for (int i=0; i<n; i++) {
            if (a[i] > max) {
                prevMax = max;
                max = a[i];
            } else if (a[i] > prevMax && a[i] < max) {
                prevMax = a[i];
            }
        }


        /*
        * Finding second smallest element.
        */
        for (int i=0; i<n; i++) {
            if (a[i] < min) {
                prevMin = min;
                min = a[i];
            } else if (a[i] < prevMin && a[i] > min) {
                prevMin = a[i];
            }
        }
        res[0] = prevMax;
        res[1] = prevMin;

        return res;
    }
}
