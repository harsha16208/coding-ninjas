public class Solution {
    public static int findKRotation(int []arr){
        // Write your code here.

        int n = arr.length;
        // Define search space
        int low = 0, high = n - 1;
        int min = Integer.MAX_VALUE, minIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    minIndex = low;
                }
                low = mid + 1;
            } else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    minIndex = mid;
                }
                high = mid - 1;
            }
        }

        return minIndex;
    }
}
