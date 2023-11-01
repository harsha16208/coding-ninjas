public class Solution {
    public static int[] twoOddNum(int []arr){
        // Write your code here.
        int xor = arr[0];
        for (int i=1; i<arr.length; i++) {
            xor^=arr[i];
        }

        //rsb
        int rsb = xor&(-xor);

        //divide x and y to two different groups
        int x=0;
        int y=0;
        for (int i=0; i<arr.length; i++) {
            if ((arr[i]&rsb) == 0) x^=arr[i];
            else y^=arr[i];
        }
        
        return new int[]{Math.max(x, y), Math.min(x, y)};
    }
}
