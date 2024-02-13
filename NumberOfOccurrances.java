public class Solution {

    static int findFirstOccurrance(int arr[], int n, int x) {
        int low = 0, high = n - 1;
        int idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                idx = mid;
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    static int findLastOccurrance(int arr[], int n, int x) {
        int low = 0, high = n - 1;
        int idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                idx = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    public static int count(int arr[], int n, int x) {
        //Your code goes here
        int fo = findFirstOccurrance(arr, n, x);
        if (fo == -1) return 0;

        int so = findLastOccurrance(arr, n, x);
        return so - fo + 1;
    }
}
