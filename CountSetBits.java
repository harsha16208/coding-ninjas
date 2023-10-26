public class Solution{
    public static int countSetBits(int n) {
        //Write your code here
        int temp = n;
        int count = 0;
        while (temp != 0) {
            if(n == 0) {
                temp--;
                n = temp;
                continue;
            }
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
